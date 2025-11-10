package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.propertiesfileutilities;

public class Login2 {
	
	
	
		//this.driver
	WebDriver driver;

	public Login2(WebDriver driver)//function parameter
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
		@FindBy(id="username")
		private WebElement UsernameTF;
		
		
		@FindBy(name="password")
		private WebElement PasswordTF;
		
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement Submitbutton;


		public WebElement getUsernameTF() {
			return UsernameTF;
		}


		public WebElement getPasswordTF() {
			return PasswordTF;
		}


		public WebElement getSubmitbutton() {
			return Submitbutton;
		}
		
		
		
		public void loginapp(String url,String username, String password) throws IOException {
			propertiesfileutilities pu=new propertiesfileutilities();
			url=pu.togetdatafrompropertyfiles("url");
			driver.get(url);
			UsernameTF.sendKeys(username);
			PasswordTF.sendKeys(password);
			Submitbutton.click();
		}
		
		
		
		
		
		

	}



