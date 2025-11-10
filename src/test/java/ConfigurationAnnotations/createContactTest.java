package ConfigurationAnnotations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import POM.Campaign;
import POM.CreateCampaignpage;
import POM.contactspage;
import POM.createcontact;
import POM.homepage;
import POM.loginpage;
import POM.select_a_Campaign;
import genericutilities.Baseclass;
import genericutilities.excelgenericutility;
import genericutilities.javautility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;

public class createContactTest extends Baseclass {
	
	@Test
	
	public void createContactwithMandatoryFields() throws IOException, InterruptedException {
		
		
		
		
		  String Campaign_name = eu.togetdatafromexcelfiles("contacts", 1, 2);
		  String Targetsize   = eu.togetdatafromexcelfiles("contacts", 1, 3);
		  String organization	=eu.togetdatafromexcelfiles("contacts", 1, 4);
		  String title	=eu.togetdatafromexcelfiles("contacts", 1, 5);
		  String contact_name	=eu.togetdatafromexcelfiles("contacts", 1, 6);
		  String mobile	=eu.togetdatafromexcelfiles("contacts", 1, 7);
		  String Select_Campaign_page_Title	=eu.togetdatafromexcelfiles("contacts", 1, 8);
		  String CampaignnDropdownDvalue	=eu.togetdatafromexcelfiles("contacts", 1, 9);
		  String Toast_msg	=eu.togetdatafromexcelfiles("contacts", 1, 10);
		

		
		
	
		Campaign camp=new Campaign(driver);
		
		camp.getAdd_Campaigns().click();
		
		Thread.sleep(3000);
		
		CreateCampaignpage camp_page=new CreateCampaignpage(driver);
		
		camp_page.Campaignwithmandatoryfield(Campaign_name, Targetsize);
		
		homepage hp=new homepage(driver);
		 WebElement camp_msg = hp.getToastmsg();
		
		
		web.explicitWaitUntilTheElementIsVisible(driver, camp_msg);
		
		
		hp.getToastmsgclosebutton().click();
		
		
	
		
	
		hp.getContacts().click();
		
		contactspage cp=new contactspage(driver);
		cp.getAdd_contact().click();
		
		createcontact contact=new createcontact(driver);
		contact.getOrganization().sendKeys(organization);
		contact.getTitle().sendKeys(title);
		contact.getContact_name().sendKeys(contact_name);
		contact.getContact_number().sendKeys("9"+ju.generateninedigitnumber());
		contact.getAdd_button().click();
		
		
		
	
		
		String parent = driver.getWindowHandle();
		
		
		web.switchdrivercontrolOnTitle(driver, Select_Campaign_page_Title);
		
		select_a_Campaign selectcampaign=new select_a_Campaign(driver);
	
		WebElement search = selectcampaign.getCampaignnDropdownDvalue();
		
		web.select(search, CampaignnDropdownDvalue);
		
		selectcampaign.getSearch_input_TF().sendKeys(Campaign_name);
	
		WebElement select_button =   selectcampaign.getSelect_button();
		
		web.explicitWaitUntilTheElementIsVisible(driver, select_button);
	
		select_button.click();
		
		driver.switchTo().window(parent);
			
	contact.getContact_create_button().click();
		
		
	
		
		WebElement msg = hp.getToastmsg();
	
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		hp.getToastmsgclosebutton().click();
		Assert.assertTrue(text.contains(Toast_msg),"Contact created");
		
		
	
		//we are giving close statement before the assertion, becase we know it will failed and its a hard assert.so it will stop the execution and 
				//the other next testcases will be skipped
		
	}

}
