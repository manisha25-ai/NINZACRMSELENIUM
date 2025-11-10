package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.javautility;
import genericutilities.webdriverutility;

public class CreateProduct {
	
	WebDriver driver;
	
	 @FindBy(name="productName")
	   private WebElement prodname;
	
		@FindBy(name="productCategory")
		private WebElement prodcategory;
		
		@FindBy(name="quantity")
		private WebElement Quantity;
		
		@FindBy(name="price")
		private WebElement PricePU;
		
		@FindBy (name="vendorId")
		private WebElement vendor;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement productcreated;
		
	
		
		
		public CreateProduct(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}




		public WebElement getProdname() {
			return prodname;
		}




		public WebElement getProdcategory() {
			return prodcategory;
		}




		public WebElement getQuantity() {
			return Quantity;
		}




		public WebElement getPricePU() {
			return PricePU;
		}




		public WebElement getVendor() {
			return vendor;
		}




		public WebElement getProductcreated() {
			return productcreated;
		}
		

		
		
		public void createproduct(String Prod_name, String Category,String quantity,String price_per_unit,String vendor_id) throws InterruptedException {
			javautility jv=new javautility();
			int num = jv.togetrandomNumber();
			prodname.sendKeys(Prod_name+num);
			webdriverutility web=new webdriverutility();
			
			web.select(prodcategory, Category);
			
			Quantity.clear();
			Thread.sleep(3000);
			Quantity.sendKeys(quantity);
			Thread.sleep(3000);
			PricePU.clear();
			PricePU.sendKeys(price_per_unit);
			
			web.select(vendor, vendor_id);
			
			Thread.sleep(3000);
			
			productcreated.click();
			

}
}