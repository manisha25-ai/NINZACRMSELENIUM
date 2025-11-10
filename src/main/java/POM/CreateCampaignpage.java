package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignpage {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='btn btn-info']")
	private WebElement Add_Campaigns;	

	///@FindAll({@FindBy(id="Name"),@FindBy(name="campaignName")})
	//	private WebElement campname;
	
	//@FindBys({@FindBy(id="Name"),@FindBy(name="campaignName")})
	//private WebElement campname;
	
	   @FindBy(name="campaignName")
	   private WebElement campname;
	
		@FindBy(name="campaignStatus")
		private WebElement campstatus;
		
		@FindBy(name="targetSize")
		private WebElement Target;
		
		@FindBy(name="targetAudience")
		private WebElement target_Audience;
		
		@FindBy (name="description")
		private WebElement Description;
		
		@FindBy(name="expectedCloseDate")
		private WebElement date;
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement campaigncreated;
		
		
		
		
		
		public CreateCampaignpage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}







		public WebElement getCampname() {
			return campname;
		}
		
		



		public WebElement getCampstatus() {
			return campstatus;
		}





		public WebElement getTarget() {
			return Target;
		}





		public WebElement getDate() {
			return date;
		}





		public WebElement getCampaigncreated() {
			return campaigncreated;
		}
		
		

		public void Campaignwithmandatoryfield(String campaign_name,String targetsize) throws InterruptedException
		{
			
			campname.sendKeys(campaign_name);
			Thread.sleep(3000);
			Target.clear();
			Target.sendKeys(targetsize);
			Thread.sleep(3000);
			
			campaigncreated.click();
			
			
		}
		

		public void Campaignwithstatus(String campaign_name,String targetsize) throws InterruptedException
		{
			
			campname.sendKeys(campaign_name);
			Thread.sleep(3000);
			Target.clear();
			Target.sendKeys(targetsize);
			Thread.sleep(3000);
			
			campaigncreated.click();
			
			
		}
		
		

		public void Campaignwithstatus(String campaign_name,String status,String targetsize) throws InterruptedException
		{
			
			campname.sendKeys(campaign_name);
			Thread.sleep(3000);
			campstatus.sendKeys(status);
			Thread.sleep(3000);
			Target.clear();
			Target.sendKeys(targetsize);
			Thread.sleep(3000);
			
			
			campaigncreated.click();
			
			
		}
		
		
		
		public void Campaignwithexpecteddate(String campaign_name,String status,String targetsize,String expected_date) throws InterruptedException
		{
			
			campname.sendKeys(campaign_name);
			Thread.sleep(3000);
			campstatus.sendKeys(status);
			Thread.sleep(3000);
			Target.clear();
			Target.sendKeys(targetsize);
			Thread.sleep(3000);
			date.sendKeys(expected_date);
			
			campaigncreated.click();
			
			
		}

}
