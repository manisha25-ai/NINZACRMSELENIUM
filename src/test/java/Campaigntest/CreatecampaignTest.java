package Campaigntest;

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
import POM.homepage;
import POM.loginpage;
import genericutilities.excelgenericutility;
import genericutilities.javautility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;

public class CreatecampaignTest {
	
	@Test
	public void CreateCampaignWithMandatoryFieldsTest() throws IOException, InterruptedException {
		
		propertiesfileutilities pu=new propertiesfileutilities();
		
		String BROWSER=pu.togetdatafrompropertyfiles("browser");
		String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
		excelgenericutility eu=new excelgenericutility();
		  String Campaign = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String Targetsize  = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String Toast_msg = eu.togetdatafromexcelfiles("Sheet1", 1, 5);
	
		  
		
		
		

		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);

		
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
		
		
	
		driver.get(URL);
		
loginpage lp=new loginpage(driver);

lp.loginapp(USERNAME, PASSWORD);
		
	
Campaign camp=new Campaign(driver);

camp.getAdd_Campaigns().click();
		
	CreateCampaignpage camp_page=new CreateCampaignpage(driver);
	camp_page.Campaignwithmandatoryfield(Campaign, Targetsize);
		
	
		
		homepage hp=new homepage(driver);
		WebElement msg = hp.getToastmsg();
		
		web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
		Assert.assertTrue(text.contains(Toast_msg),"Campaign created");
	//	if(text.contains(Toast_msg))
			
	//	{
			
	//		Reporter.log("Campaign created",true);
	//	}

		
	//	else
	//	{
			
	//		Reporter.log("Campaign not created",true);
	//	}
		
		
		hp.getToastmsgclosebutton().click();
		
		System.out.println("Hello Manisha!!!!!");
		hp.logout();
		
		driver.quit();
	}
	
	
	@Test
	
	public void createCampaignWithStatusTest() throws InterruptedException, IOException {

		propertiesfileutilities pu=new propertiesfileutilities();
		// read the data from prop using getproprty method by passing key/
		String BROWSER=pu.togetdatafrompropertyfiles("browser");
		String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
		excelgenericutility eu=new excelgenericutility();
		  String Campaignname = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String target_size   = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String status	=eu.togetdatafromexcelfiles("Sheet1", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles("Sheet1", 1, 5);
			
				
				
				
			
				
				ChromeOptions settings = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("profile.password_manager_leak_detection", false);
				settings.setExperimentalOption("prefs", prefs);
	
				
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
				
				
			
				driver.get(URL);
				
				loginpage lp=new loginpage(driver);
				
				lp.loginapp(USERNAME, PASSWORD);
				
		
				
				
			
				
				Campaign camp=new Campaign(driver);
				
				camp.getAdd_Campaigns().click();
				
				Thread.sleep(3000);
				
				CreateCampaignpage camp_page=new CreateCampaignpage(driver);
				camp_page.Campaignwithstatus(Campaignname, status,target_size);
				
				homepage hp=new homepage(driver);
				WebElement msg = hp.getToastmsg();
			web.explicitWaitUntilTheElementIsVisible(driver, msg);
				
				String text = msg.getText();
				Assert.assertTrue(text.contains(Toast_msg),"Campaign created");
				
				
				
				//Closing the Message
				hp.getToastmsgclosebutton().click();
				hp.logout();
				
				driver.quit();
		
	}
	
	
	@Test
	
public void createCampaignWithExpectedCloseDateTest() throws InterruptedException, IOException {
propertiesfileutilities pu=new propertiesfileutilities();
		
		String BROWSER=pu.togetdatafrompropertyfiles("browser");
		String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
		excelgenericutility eu=new excelgenericutility();
		  String Campaignname = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String target_size   = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String status	=eu.togetdatafromexcelfiles("Sheet1", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles("Sheet1", 1, 5);
		    javautility ju=new javautility();
				
				String Expecteddate = ju.getdate(10);
				
				System.out.println(Expecteddate);
				
		
		
		
	
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);

		
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
		
		
	
		driver.get(URL);
		
		loginpage lp=new loginpage(driver);
		
		lp.loginapp(USERNAME, PASSWORD);
		
		
		
		
Campaign camp=new Campaign(driver);
		
camp.getAdd_Campaigns().click();
		
		Thread.sleep(3000);
		CreateCampaignpage camp_page=new CreateCampaignpage(driver);
		camp_page.Campaignwithexpecteddate(Campaignname, status, target_size, Expecteddate);
		
		
		homepage hp=new homepage(driver);
		WebElement msg = hp.getToastmsg();
		
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
		Assert.assertTrue(text.contains(Toast_msg),"Campaign created");
		
		
		
	
		hp.getToastmsgclosebutton().click();
		hp.logout();
		
		driver.quit();
		
	}
	

}
