package CreateProductTest;

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

import POM.CreateProduct;
import POM.Product;
import POM.homepage;
import POM.loginpage;
import genericutilities.excelgenericutility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;

public class CreateProductTest {

	
	@Test
	public void createProductWithMandatoryFields() throws InterruptedException, IOException
	{
		
		propertiesfileutilities pu=new propertiesfileutilities();
		
		String BROWSER=pu.togetdatafrompropertyfiles("browser");
		String URL = pu.togetdatafrompropertyfiles("url");
		String USERNAME = pu.togetdatafrompropertyfiles("username");
		String PASSWORD = pu.togetdatafrompropertyfiles("password");
		
		
	
		
				
		
		
		excelgenericutility eu=new excelgenericutility();
		  String Product_name = eu.togetdatafromexcelfiles_Products("Products", 1, 0);
		  String category = eu.togetdatafromexcelfiles_Products("Products", 1, 1);
		  String Quantity  = eu.togetdatafromexcelfiles_Products("Products", 1, 2);
		  String Price_per_unit = eu.togetdatafromexcelfiles_Products("Products", 1, 3);
		  String vendorid = eu.togetdatafromexcelfiles_Products("Products", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles_Products("Products", 1, 5);
		  
		  System.out.println(Quantity);
	
		  
			
			
				
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
					
				
					homepage hp=new homepage(driver);
					hp.getProduct().click();
					
					Product p=new Product(driver);
					p.getAdd_Product().click();
					
					CreateProduct cp=new CreateProduct(driver);
					cp.createproduct(Product_name,category,Quantity,Price_per_unit,vendorid);
					
					
					
					
					WebElement msg = hp.getToastmsg();
					
					web.explicitWaitUntilTheElementIsVisible(driver, msg);
					
					String text = msg.getText();
					
					Assert.assertTrue(text.contains(Toast_msg),"Product created");
					
					
					
					//Closing the Message
					hp.getToastmsgclosebutton().click();
					hp.logout();
					
					driver.quit();
	}
}
