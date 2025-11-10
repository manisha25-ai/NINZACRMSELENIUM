package POMImplementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.Campaign;
import POM.CreateCampaignpage;
import POM.homepage;
import POM.loginpage;
import genericutilities.excelgenericutility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;

public class createcampagnwithstatustest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
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
				camp_page.Campaignwithstatus(Campaignname, status,target_size);
				
				//Campaign xxxxxxxxxxx Successfully added
				//Verification
				homepage hp=new homepage(driver);
				WebElement msg = hp.getToastmsg();
			web.explicitWaitUntilTheElementIsVisible(driver, msg);
				
				String text = msg.getText();
				
				if(text.contains(Toast_msg))
					
				{
					
					System.out.println("Campaign created");
				}

				
				else
				{
					
					System.out.println("Campaign not created");
				}
				
				//Closing the Message
				hp.getToastmsgclosebutton().click();
				hp.logout();
				
				driver.quit();
			}

	}


