package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign {
	
	
WebDriver driver;
	
@FindBy(xpath="//button[@class='btn btn-info']")
private WebElement Add_Campaigns;	

	
	
	
	
	
	public Campaign(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}





	public WebElement getAdd_Campaigns() {
		return Add_Campaigns;
	}







}
