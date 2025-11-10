package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.webdriverutility;

public class homepage {
	
WebDriver driver;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaigns;
	
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts;
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement Usericon;
	
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement Logout;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastmsg;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement toastmsgclosebutton;
	
	public homepage (WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement getCampaigns() {
		return campaigns;
	}


	


	public WebElement getUsericon() {
		return Usericon;
	}


	public WebElement getLogout() {
		return Logout;
	}


	public WebElement getContacts() {
		return contacts;
	}



	public WebElement getToastmsg() {
		return toastmsg;
	}


	

	public WebElement getProduct() {
		return product;
	}


	public WebElement getToastmsgclosebutton() {
		return toastmsgclosebutton;
	}


	//Business libraries
	
	public void logout()
	{
	
		WebElement we = Usericon;
		webdriverutility web=new webdriverutility();
		web.mouseHoverAction(driver, we);
		Logout.click();
	}


	


	
	

}
