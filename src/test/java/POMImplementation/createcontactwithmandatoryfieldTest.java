package POMImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.Campaign;
import POM.CreateCampaignpage;
import POM.contactspage;
import POM.createcontact;
import POM.homepage;
import POM.loginpage;
import POM.select_a_Campaign;
import genericutilities.excelgenericutility;
import genericutilities.javautility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;

public class createcontactwithmandatoryfieldTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		propertiesfileutilities pu=new propertiesfileutilities();
		// read the data from prop using getproprty method by passing key/
		String BROWSER=pu.togetdatafrompropertyfiles("browser");
		String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
		excelgenericutility eu=new excelgenericutility();
		  String Campaign_name = eu.togetdatafromexcelfiles("contacts", 1, 2);
		  String Targetsize   = eu.togetdatafromexcelfiles("contacts", 1, 3);
		  String organization	=eu.togetdatafromexcelfiles("contacts", 1, 4);
		  String title	=eu.togetdatafromexcelfiles("contacts", 1, 5);
		  String contact_name	=eu.togetdatafromexcelfiles("contacts", 1, 6);
		  String mobile	=eu.togetdatafromexcelfiles("contacts", 1, 7);
		  String Select_Campaign_page_Title	=eu.togetdatafromexcelfiles("contacts", 1, 8);
		  String CampaignnDropdownDvalue	=eu.togetdatafromexcelfiles("contacts", 1, 9);
		  String Toast_msg	=eu.togetdatafromexcelfiles("contacts", 1, 10);
		
javautility ju=new javautility();
		
		
	//Avoiding Popup, no need to understand--it come becoz we use same password--for chrome only
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
//Launching Browser
		
		WebDriver driver = null;
	
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		driver=new ChromeDriver(settings);
		
		
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		
       else if(BROWSER.equalsIgnoreCase("firefox"))
	driver=new FirefoxDriver();
			
		
		
       else if(BROWSER.equalsIgnoreCase("safari"))
	      driver=new SafariDriver();

		
		
		
		driver.manage().window().maximize();
		
		webdriverutility web=new webdriverutility();
		  web.impcitwait(driver);
		
		
		//login action
		driver.get(URL);
		
		loginpage lp=new loginpage(driver);
		
		lp.loginapp(USERNAME, PASSWORD);
		
		
		//create campaign
		
		Campaign camp=new Campaign(driver);
		
		camp.getAdd_Campaigns().click();
		
		Thread.sleep(3000);
		
		CreateCampaignpage camp_page=new CreateCampaignpage(driver);
		
		camp_page.Campaignwithmandatoryfield(Campaign_name, Targetsize);
		
		homepage hp=new homepage(driver);
		 WebElement camp_msg = hp.getToastmsg();
		
		
		web.explicitWaitUntilTheElementIsVisible(driver, camp_msg);
		
		
		hp.getToastmsgclosebutton().click();
		
		
		//click on contacts.
		
	
		hp.getContacts().click();
		
		contactspage cp=new contactspage(driver);
		cp.getAdd_contact().click();
		
		createcontact contact=new createcontact(driver);
		contact.getOrganization().sendKeys(organization);
		contact.getTitle().sendKeys(title);
		contact.getContact_name().sendKeys(contact_name);
		contact.getContact_number().sendKeys("9"+ju.generateninedigitnumber());
		contact.getAdd_button().click();
		
		
		
		//before switching we are capturing parent id
		
		String parent = driver.getWindowHandle();
		//switch to driver control from parent to child
		
		web.switchdrivercontrolOnTitle(driver, Select_Campaign_page_Title);
		
		select_a_Campaign selectcampaign=new select_a_Campaign(driver);
		//select from dropdown
		WebElement search = selectcampaign.getCampaignnDropdownDvalue();
		
		web.select(search, CampaignnDropdownDvalue);
		//pass the campaign name
		selectcampaign.getSearch_input_TF().sendKeys(Campaign_name);
		//select button once appear then click.
		WebElement select_button =   selectcampaign.getSelect_button();
		
		web.explicitWaitUntilTheElementIsVisible(driver, select_button);
		//click on select_button
		select_button.click();
		
		driver.switchTo().window(parent);
		//create_contact
		
	contact.getContact_create_button().click();
		
		
		//Verification
		
		WebElement msg = hp.getToastmsg();
		//Message is taking time to display, so we have to give  wait. so our element has to wait until the toastmsg is visible
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
		if(text.contains(Toast_msg))
			
		{
			
			System.out.println("contact created");
		}

		
		else
		{
			
			System.out.println("contact not created");
		}
		
		//Closing the Message
		hp.getToastmsgclosebutton().click();
		hp.logout();
		
		driver.quit();

	}

}
