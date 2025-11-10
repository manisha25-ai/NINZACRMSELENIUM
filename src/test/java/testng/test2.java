package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class test2 {
	

	
	@Test
	public void productcreation() throws InterruptedException
	{
		
		Reporter.log("ProductCreation",true);
		
	}
	
	@Test(dependsOnMethods = {"productcreation","updateProduct"})
	public void deleteProduct()
	{
		Reporter.log("deleteProduct",true);
		
	}
	
	@Test
	public void updateProduct()
	{
		Reporter.log("updateProduct",true);
		
	}

}
