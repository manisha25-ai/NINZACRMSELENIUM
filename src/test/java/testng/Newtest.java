package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Newtest {
	
	@Test(priority = -200, invocationCount = 5, threadPoolSize = 2)
	public void productcreation() throws InterruptedException
	{
		
		Reporter.log("ProductCreation",true);
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(dependsOnMethods = {"productcreation","updateProduct"})
	public void deleteProduct()
	{
		Reporter.log("deleteProduct",true);
		
	}
	
	
	

}
