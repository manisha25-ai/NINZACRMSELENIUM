package genericutilities;

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
		  String Campaign = eu.togetdatafromexcelfiles("contacts", 1, 2);
		  String Targetsize   = eu.togetdatafromexcelfiles("contacts", 1, 3);
		  String organization	=eu.togetdatafromexcelfiles("contacts", 1, 4);
		  String title	=eu.togetdatafromexcelfiles("contacts", 1, 5);
		  String contact_name	=eu.togetdatafromexcelfiles("contacts", 1, 6);
		  String mobile	=eu.togetdatafromexcelfiles("contacts", 1, 7);
		
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
		
driver.findElement(By.id("username")).sendKeys(USERNAME);
		
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//create campaign
		
driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		
		Thread.sleep(3000);
		driver.findElement(By.name("targetSize")).clear();
		
		driver.findElement(By.name("targetSize")).sendKeys(Targetsize);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement camp_msg = driver.findElement(By.xpath("//div[@role='alert']"));
		web.explicitWaitUntilTheElementIsVisible(driver, camp_msg);
		
		
		
		driver.findElement(By.xpath("(//button[@type='button']) [3]")).click();
		
		//click on contacts.
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		
		driver.findElement(By.name("organizationName")).sendKeys(organization);
		
		driver.findElement(By.name("title")).sendKeys(title);
		
		driver.findElement(By.name("contactName")).sendKeys(contact_name);
		
		driver.findElement(By.name("mobile")).sendKeys("9"+ju.generateninedigitnumber());
		
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		//before switching we are capturing parent id
		
		String parent = driver.getWindowHandle();
		//switch to driver control from parent to child
		
		web.switchdrivercontrolOnTitle(driver, "Select Campaign");
		
		WebElement search = driver.findElement(By.id("search-criteria"));
		
		web.select(search, 1);
		
		driver.findElement(By.id("search-input")).sendKeys(Campaign);
		
		WebElement select_button = driver.findElement(By.xpath("//button[@class='select-btn']"));
		
		web.explicitWaitUntilTheElementIsVisible(driver, select_button);
		
		select_button.click();
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		
		//Verification
		
		WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		//Message is taking time to display, so we have to give  wait. so our element has to wait until the toastmsg is visible
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
		if(text.contains("Successfully Added"))
			
		{
			
			System.out.println("contact created");
		}

		
		else
		{
			
			System.out.println("contact not created");
		}
		
		//Closing the Message
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
		WebElement we = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		
		web.mouseHoverAction(driver, we);
		
		
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		driver.quit();

	}

}
