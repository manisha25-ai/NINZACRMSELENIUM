package genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
	
	public void impcitwait( WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	
	public void explicitWaitUntilTheElementIsVisible(WebDriver driver,WebElement toast_msg)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		//Hey driver please wait until the camp_msg is visible.	
		wait.until(ExpectedConditions.visibilityOf(toast_msg));
	}
	
	public void mouseHoverAction(WebDriver driver, WebElement we)
	
	
	{
		Actions a = new Actions(driver);
		
		a.moveToElement(we).perform();	
	}
	
	
	public void select(WebElement we, int index)
	
	{
		
      Select s=new Select(we);
		
		s.selectByIndex(index);
	}
	
	
public void select(WebElement we, String value)
	
	{
		
      Select s=new Select(we);
		
		s.selectByValue(value);
	}


public void select(String Visible_text,WebElement we)

{
	
  Select s=new Select(we);
	
	s.selectByVisibleText(Visible_text);
}

public void deselect(WebElement we, int index)

{
	
  Select s=new Select(we);
	
	s.deselectByIndex(index);
}


public void deselect(WebElement we, String value)

{
	
  Select s=new Select(we);
	
	s.deselectByValue(value);
}


public void deselect(String Visible_text,WebElement we)

{
	
  Select s=new Select(we);
	
	s.deselectByVisibleText(Visible_text);
}

public void switchdrivercontrolOnTitle(WebDriver driver,String title){
	
	
	String parent = driver.getWindowHandle();
	Set<String> all_ids = driver.getWindowHandles();
	all_ids.remove(parent);
	//swiching to child window.
	for (String id : all_ids) {
		
		driver.switchTo().window(id);
		
		if(driver.getTitle().contains(title))
			break;
		}
}


public void switchdrivercontrolOnTitle(String url,WebDriver driver){
	
	
	String parent = driver.getWindowHandle();
	Set<String> all_ids = driver.getWindowHandles();
	all_ids.remove(parent);
	//swiching to child window.
	for (String id : all_ids) {
		
		driver.switchTo().window(id);
		
		if(driver.getCurrentUrl().contains(url))
			break;
		}
}



public void switchtoframe(WebDriver driver, int index)
{
driver.switchTo().frame(index);

}

public void switchtoframe(WebDriver driver, String nameorId)
{
driver.switchTo().frame(nameorId);

}

public void switchtoframe(WebDriver driver, WebElement we)
{
driver.switchTo().frame(we);

}


public void switchToalertaccept(WebDriver driver) {
	
	driver.switchTo().alert().accept();
}


public void switchToalertdismiss(WebDriver driver) {
	
	driver.switchTo().alert().dismiss();
}


public void switchToalertsendkeys(WebDriver driver, String keys) {
	
	driver.switchTo().alert().sendKeys(keys);
}


public String switchToalertgettext(WebDriver driver) {
	
	String text = driver.switchTo().alert().getText();
	
	
	return text;
}


public void takescreenshot(WebDriver driver, String File_Path,String File_name) throws IOException {
	
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	
	File temp = ts.getScreenshotAs(OutputType.FILE);
	
	File dest = new File("./"+File_Path+"/"+File_name);
	
	FileHandler.copy(temp, dest);
}


public void doubleclick(WebDriver driver, WebElement we)
{
	
	Actions a=new Actions(driver);
	
	a.doubleClick(we).perform();
}


public void rightclick(WebDriver driver, WebElement we)
{
	
	Actions a=new Actions(driver);
	
	a.contextClick(we).perform();
}


public void dragandDrop(WebDriver driver, WebElement source,WebElement target)
{
	
	Actions a=new Actions(driver);
	
	a.dragAndDrop(source, target).perform();
}


public void scrolltoelement(WebDriver driver, WebElement we)
{
	
	Actions a=new Actions(driver);
	a.scrollToElement(we).perform();
}

public void Clickandhold(WebDriver driver, WebElement we)
{
	
	Actions a=new Actions(driver);
	a.clickAndHold(we).perform();
}


public void release(WebDriver driver, WebElement we)
{
	
	Actions a=new Actions(driver);
	a.release(we).perform();
}

}






