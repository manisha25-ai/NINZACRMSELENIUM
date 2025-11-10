package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactspage {
	
	WebDriver driver;
	
	public contactspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Create Contact']")
	private WebElement Add_contact;

	public WebElement getAdd_contact() {
		return Add_contact;
	}
	
	
	
	
	
	
	

}
