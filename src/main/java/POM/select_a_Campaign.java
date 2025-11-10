package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class select_a_Campaign {
	
WebDriver driver;
	
	public select_a_Campaign (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search-criteria")
	private WebElement CampaignnDropdownDvalue;
	
	@FindBy(id="search-input")
	private WebElement search_input_TF;
	
	@FindBy(xpath="//button[@class='select-btn']")
	private WebElement select_button;

	public WebElement getCampaignnDropdownDvalue() {
		return CampaignnDropdownDvalue;
	}

	public WebElement getSearch_input_TF() {
		return search_input_TF;
	}

	public WebElement getSelect_button() {
		return select_button;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
