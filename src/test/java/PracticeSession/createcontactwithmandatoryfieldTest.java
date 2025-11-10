package PracticeSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createcontactwithmandatoryfieldTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Pavilion\\Documents\\Selenium_DDT\\Common_data.properties");
		// Create object of properties file.
		Properties prop=new Properties();
// Now load the data into prop.
		prop.load(fis);
		// read the data from prop using getproprty method by passing key/
		String BROWSER=prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\Pavilion\\selenium_Practice\\NINJACRMAdVANCESELENIUM\\src\\test\\resources\\E32.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
	Sheet sheet = wb.getSheet("contacts");
	Row row = sheet.getRow(1);
	Cell cell = row.getCell(2);
	String Campaign = cell.getStringCellValue();
	String Targetsize = wb.getSheet("contacts").getRow(1).getCell(3).getStringCellValue();
	String organization = wb.getSheet("contacts").getRow(1).getCell(4).getStringCellValue();
	String title = wb.getSheet("contacts").getRow(1).getCell(5).getStringCellValue();
	String contact_name = wb.getSheet("contacts").getRow(1).getCell(6).getStringCellValue();
	String mobile = wb.getSheet("contacts").getRow(1).getCell(7).getStringCellValue();
	
	
	 
	wb.close();
		
		
		
	//Avoiding Popup, no need to understand--it come becoz we use same password--for chrome only
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
//Launching Browser
		
		WebDriver driver = null;
	
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		driver=new ChromeDriver(settings);
		
		
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		
       else if(BROWSER.equalsIgnoreCase("firefox"))
	driver=new FirefoxDriver();
			
		
		
       else if(BROWSER.equalsIgnoreCase("safari"))
	      driver=new SafariDriver();

		
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		//login action
		driver.get(URL);
		
driver.findElement(By.id("username")).sendKeys(USERNAME);
		
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//create campaign
		
driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.name("campaignName")).sendKeys(Campaign);
		
		Thread.sleep(3000);
		driver.findElement(By.name("targetSize")).clear();
		
		driver.findElement(By.name("targetSize")).sendKeys(Targetsize);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement camp_msg = driver.findElement(By.xpath("//div[@role='alert']"));
		//Message is taking time to display, so we have to give  wait. so our element has to wait until the toastmsg is visible
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	//Hey driver please wait until the camp_msg is visible.	
	wait.until(ExpectedConditions.visibilityOf(camp_msg));
		
		driver.findElement(By.xpath("(//button[@type='button']) [3]")).click();
		
		//click on contacts.
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		
		driver.findElement(By.name("organizationName")).sendKeys(organization);
		
		driver.findElement(By.name("title")).sendKeys(title);
		
		driver.findElement(By.name("contactName")).sendKeys(contact_name);
		
		driver.findElement(By.name("mobile")).sendKeys(mobile);
		
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> all_ids = driver.getWindowHandles();
		all_ids.remove(parent);
		//swiching to child window.
		for (String id : all_ids) {
			
			driver.switchTo().window(id);
			
			if(driver.getTitle().contains("Select Campaign"))
				break;
			}
		
		WebElement search = driver.findElement(By.id("search-criteria"));
		
		Select s=new Select(search);
		
		s.selectByIndex(1);
		
		driver.findElement(By.id("search-input")).sendKeys(Campaign);
		
		WebElement select_button = driver.findElement(By.xpath("//button[@class='select-btn']"));
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait1.until(ExpectedConditions.visibilityOf(select_button));
		
		select_button.click();
		
		driver.switchTo().window(parent);
		
		driver.findElement(By.xpath("//button[text()='Create Contact']")).click();
		
		
		//Verification
		
		WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		//Message is taking time to display, so we have to give  wait. so our element has to wait until the toastmsg is visible
		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(30));
	//Hey driver please wait until the msg is visible.	
	wait2.until(ExpectedConditions.visibilityOf(msg));
		
		String text = msg.getText();
		
		if(text.contains("Successfully Added"))
			
		{
			
			System.out.println("contact created");
		}

		
		else
		{
			
			System.out.println("contact not created");
		}
		
		//Closing the Message
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
		WebElement we = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		
		Actions a = new Actions(driver);
		
		a.moveToElement(we).perform();
		
		
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		driver.quit();

	}

}
