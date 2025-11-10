package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {

	
	
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement Add_Product;	

		
		
		
		
		
		public Product(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}






		public WebElement getAdd_Product() {
			return Add_Product;
		}
		
		
		
		
		
		
		
		
		
		
		
}
