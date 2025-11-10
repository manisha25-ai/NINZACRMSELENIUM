package genericutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

public class createcampaignwithexpectedclosedateTEST {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Utilities
		propertiesfileutilities pu=new propertiesfileutilities();
		
		String BROWSER=pu.togetdatafrompropertyfiles("browser");
		String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
		excelgenericutility eu=new excelgenericutility();
		  String Campaignname = eu.togetdatafromexcelfiles("Sheet1", 1, 2);
		  String target_size   = eu.togetdatafromexcelfiles("Sheet1", 1, 3);
		  String status	=eu.togetdatafromexcelfiles("Sheet1", 1, 4);
		
		    javautility ju=new javautility();
				
				String Expecteddate = ju.getdate(30);
				
				System.out.println(Expecteddate);
				
		
		
		
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
		driver.findElement(By.name("campaignName")).sendKeys(Campaignname);
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("campaignStatus")).sendKeys(status);
		Thread.sleep(3000);
		driver.findElement(By.name("targetSize")).clear();
		
		driver.findElement(By.name("targetSize")).sendKeys(target_size);
		Thread.sleep(3000);
		
		driver.findElement(By.name("expectedCloseDate")).sendKeys(Expecteddate);
		
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Campaign xxxxxxxxxxx Successfully added
		//Verification
		
		WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		//Message is taking time to display, so we have to give  wait. so our element has to wait until the toastmsg is visible
	web.explicitWaitUntilTheElementIsVisible(driver, msg);
		
		String text = msg.getText();
		
		if(text.contains("Successfully Added"))
			
		{
			
			System.out.println("Campaign created");
		}

		
		else
		{
			
			System.out.println("Campaign not created");
		}
		
		//Closing the Message
		driver.findElement(By.xpath("(//button[@type='button']) [3]")).click();
		
		
		WebElement we = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		
		web.mouseHoverAction(driver, we);
		
		
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		driver.quit();
	}

	}


