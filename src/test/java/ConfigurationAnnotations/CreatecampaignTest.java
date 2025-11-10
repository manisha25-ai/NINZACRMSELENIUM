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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.Campaign;
import POM.CreateCampaignpage;
import POM.homepage;
import POM.loginpage;
import genericutilities.Baseclass;
import genericutilities.excelgenericutility;
import genericutilities.javautility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;
//making connection. it will keep on monitor if any tc failed so it will automatically take ss.and in bracket we are giving fully qualified path
@Listeners(genericutilities.ListenerImplementation.class)
public class CreatecampaignTest extends Baseclass {
	
	@Test
	public void CreateCampaignWithMandatoryFieldsTest() throws IOException, InterruptedException {
		
		
		
	
		  String Campaign = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String Targetsize  = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String Toast_msg = eu.togetdatafromexcelfiles("Sheet1", 1, 5);
	

		
Campaign camp=new Campaign(driver);

camp.getAdd_Campaigns().click();
		
	CreateCampaignpage camp_page=new CreateCampaignpage(driver);
	camp_page.Campaignwithmandatoryfield(Campaign, Targetsize);
		
	
		
		homepage hp=new homepage(driver);
		WebElement msg = hp.getToastmsg();
		
		web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		hp.getToastmsgclosebutton().click();
		Assert.assertTrue(text.contains(Toast_msg),"Campaign created");
		
		
		
		
		
		
	}
	
	
	@Test
	
	public void createCampaignWithStatusTest() throws InterruptedException, IOException {

		
		
	
		  String Campaignname = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String target_size   = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String status	=eu.togetdatafromexcelfiles("Sheet1", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles("Sheet1", 1, 5);
			
				
				
				
			
				
			
				
				
			
				
				Campaign camp=new Campaign(driver);
				
				camp.getAdd_Campaigns().click();
				
				Thread.sleep(3000);
				
				CreateCampaignpage camp_page=new CreateCampaignpage(driver);
				camp_page.Campaignwithstatus(Campaignname, status,target_size);
				
				homepage hp=new homepage(driver);
				WebElement msg = hp.getToastmsg();
			web.explicitWaitUntilTheElementIsVisible(driver, msg);
				
				String text = msg.getText();
				
				//Closing the Message
				hp.getToastmsgclosebutton().click();
				Assert.assertTrue(text.contains(Toast_msg),"Campaign created");

				
			
				
				
				
		
	}
	
	
	@Test
	
public void createCampaignWithExpectedCloseDateTest() throws InterruptedException, IOException {

		
		
		  String Campaignname = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String target_size   = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String status	=eu.togetdatafromexcelfiles("Sheet1", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles("Sheet1", 1, 5);
		    
				
				String Expecteddate = ju.getdate(10);
				
				System.out.println(Expecteddate);
				
		
		
		
	
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);

		

		
		
		
		driver.manage().window().maximize();
		
		webdriverutility web=new webdriverutility();
		  web.impcitwait(driver);
		
		
	
		
		
		
		
Campaign camp=new Campaign(driver);
		
camp.getAdd_Campaigns().click();
		
		Thread.sleep(3000);
		CreateCampaignpage camp_page=new CreateCampaignpage(driver);
		camp_page.Campaignwithexpecteddate(Campaignname, status, target_size, Expecteddate);
		
		
		homepage hp=new homepage(driver);
		WebElement msg = hp.getToastmsg();
		
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
	//	if(text.contains(Toast_msg))
			
//		{
			
			Reporter.log("Campaign created",true);
	//	}

		
//		else
	//	{
			
	//		Reporter.log("Campaign not created",true);
		//}
		
			//Closing the Message
			hp.getToastmsgclosebutton().click();
	
		
		Assert.assertTrue(text.contains(Toast_msg),"Campaign created");

		
	
		//we are giving close statement before the assertion, becase we know it will failed and its a hard assert.so it will stop the execution and 
		//the other next testcases will be skipped
		
	
		
	}
	

}
