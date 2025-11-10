package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createcontact {
	
	WebDriver driver;
	
	public createcontact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="organizationName")
	private WebElement organization;
	
	@FindBy(name="title")
	private WebElement Title;
	
	@FindBy(name="contactName")
	private WebElement Contact_name;
	
	
	@FindBy(name="mobile")
	private WebElement contact_number;
	
	
	@FindBy(xpath="//*[name()='svg' and @data-icon='plus']")
	private WebElement Add_button;
	
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement contact_create_button;

	public WebElement getOrganization() {
		return organization;
	}


	public WebElement getTitle() {
		return Title;
	}


	public WebElement getContact_name() {
		return Contact_name;
	}


	public WebElement getContact_number() {
		return contact_number;
	}


	public WebElement getAdd_button() {
		return Add_button;
	}


	public WebElement getContact_create_button() {
		return contact_create_button;
	}
	
	
	

	

	
	

}
