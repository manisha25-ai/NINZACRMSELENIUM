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

import POM.CreateProduct;
import POM.Product;
import POM.homepage;
import POM.loginpage;
import genericutilities.Baseclass;
import genericutilities.excelgenericutility;
import genericutilities.propertiesfileutilities;
import genericutilities.webdriverutility;

public class CreateProductTest extends Baseclass {

	
	@Test
	public void createProductWithMandatoryFields() throws InterruptedException, IOException
	{
		
	
		  String Product_name = eu.togetdatafromexcelfiles_Products("Products", 1, 0);
		  String category = eu.togetdatafromexcelfiles_Products("Products", 1, 1);
		  String Quantity  = eu.togetdatafromexcelfiles_Products("Products", 1, 2);
		  String Price_per_unit = eu.togetdatafromexcelfiles_Products("Products", 1, 3);
		  String vendorid = eu.togetdatafromexcelfiles_Products("Products", 1, 4);
		  String Toast_msg=eu.togetdatafromexcelfiles_Products("Products", 1, 5);
		  
		  System.out.println(Quantity);
	
		  
					
				
					homepage hp=new homepage(driver);
					hp.getProduct().click();
					
					Product p=new Product(driver);
					p.getAdd_Product().click();
					
					CreateProduct cp=new CreateProduct(driver);
					cp.createproduct(Product_name,category,Quantity,Price_per_unit,vendorid);
					
					
					
					
					WebElement msg = hp.getToastmsg();
					
					web.explicitWaitUntilTheElementIsVisible(driver, msg);
					
					String text = msg.getText();
					hp.getToastmsgclosebutton().click();
					Assert.assertTrue(text.contains(Toast_msg),"product created");
					
				
				
					//we are giving close statement before the assertion, becase we know it will failed and its a hard assert.so it will stop the execution and 
					//the other next testcases will be skipped
					
	}
}
