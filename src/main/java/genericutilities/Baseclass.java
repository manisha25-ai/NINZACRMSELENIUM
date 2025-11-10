package genericutilities;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import POM.homepage;
import POM.loginpage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Baseclass {
	
	
	public 	 WebDriver driver = null;
	public static WebDriver sdriver=null;
	public  propertiesfileutilities pu=new propertiesfileutilities();
	public excelgenericutility eu=new excelgenericutility();
	public javautility ju=new javautility();
	public webdriverutility web=new webdriverutility();
	
	 @BeforeSuite(groups={"smoke","regression"})
	  public void beforeSuite() {
		 System.out.println("Establish the datbase connection");
	  }
	 
	 @BeforeTest(groups={"smoke","regression"})
	  public void beforeTest() {
		 System.out.println("Pre-Condition for parallel execution");
	  }
	// @Parameters("BROWSER")
	@BeforeClass(groups={"smoke","regression"})
	
	//  public void beforeClass(String browser) throws IOException {
	 public void beforeClass() throws IOException {
		 System.out.println("Launch the browser");
		 //taking value from xml file, string browser(chrome/firefox/edge)
	//	String BROWSER=browser;
			//not taking value from properties utility
	String BROWSER=pu.togetdatafrompropertyfiles("browser");
		// Taking value from cmd line
		// String BROWSER=System.getProperty("browser");
			
		   ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);

			
		
		
			
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver(settings);
			
			
			else if(BROWSER.equalsIgnoreCase("edge"))
				driver=new EdgeDriver();
			
	       else if(BROWSER.equalsIgnoreCase("firefox"))
		driver=new FirefoxDriver();
				
			
			
	       else if(BROWSER.equalsIgnoreCase("safari"))
		      driver=new SafariDriver();

			sdriver=driver;
			
			
			
			driver.manage().window().maximize();
			
			webdriverutility web=new webdriverutility();
			  web.impcitwait(driver);
			
			
	  }
 
  @BeforeMethod(groups={"smoke","regression"})
  public void beforeMethod() throws IOException {
	  
	  System.out.println("Login");
	  
	  String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
	  loginpage lp=new loginpage(driver);

	  lp.loginapp(URL,USERNAME, PASSWORD);
  }

  @AfterMethod(groups={"smoke","regression"})
  public void afterMethod() {
	  System.out.println("Logout");
	  homepage hp=new homepage(driver);
	  hp.logout();
  }



  @AfterClass(groups={"smoke","regression"})
  public void afterClass() {
	  
	  System.out.println("close the browser");
	  
	  driver.quit();
  }

  

  @AfterTest(groups={"smoke","regression"})
  public void afterTest() {
	  
	  System.out.println("Post-condition for parallel execution");
  }

  

  @AfterSuite(groups={"smoke","regression"})
  public void afterSuite() {
	  System.out.println("Close the database connection");
  }

}
