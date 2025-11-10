package distributed;

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
import org.testng.Reporter;
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
		
		if(text.contains(Toast_msg))
			
		{
			
			Reporter.log("Campaign created",true);
		}

		
		else
		{
			
			Reporter.log("Campaign not created",true);
		}
		
		
		hp.getToastmsgclosebutton().click();
		
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
				
				if(text.contains(Toast_msg))
					
				{
					
					Reporter.log("Campaign created",true);
				}

				
				else
				{
					
					Reporter.log("Campaign not created",true);
				}
				
				//Closing the Message
				hp.getToastmsgclosebutton().click();
				
		
	}
	
	
	@Test
	
public void createCampaignWithExpectedCloseDateTest() throws InterruptedException, IOException {

		
		
		  String Campaignname = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String target_size   = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String status	=eu.togetdatafromexcelfiles("Sheet1", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles("Sheet1", 1, 5);
		    
				
				String Expecteddate = ju.getdate(10);
				
				System.out.println(Expecteddate);
				
		
		
		
	
		
		
		
		
Campaign camp=new Campaign(driver);
		
camp.getAdd_Campaigns().click();
		
		Thread.sleep(3000);
		CreateCampaignpage camp_page=new CreateCampaignpage(driver);
		camp_page.Campaignwithexpecteddate(Campaignname, status, target_size, Expecteddate);
		
		
		homepage hp=new homepage(driver);
		WebElement msg = hp.getToastmsg();
		
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
		if(text.contains(Toast_msg))
			
		{
			
			Reporter.log("Campaign created",true);
		}

		
		else
		{
			
			Reporter.log("Campaign not created",true);
		}
		
	
		hp.getToastmsgclosebutton().click();
	
		
	}
	

}
