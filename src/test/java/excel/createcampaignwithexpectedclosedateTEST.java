package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
import org.openqa.selenium.support.ui.WebDriverWait;

public class createcampaignwithexpectedclosedateTEST {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		// create java representation, copy path from local keep path in double quotes and remove starting slash "/"
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
	   String Campaignname = wb.getSheet("Sheet1").getRow(7).getCell(2).getStringCellValue();
	 String status = wb.getSheet("Sheet1").getRow(7).getCell(3).getStringCellValue();
	   String target_size = wb.getSheet("Sheet1").getRow(7).getCell(4).getStringCellValue();
	wb.close();
		
		
		//Generate date after 30 days.
		
		//Current date
				Date d=new Date();
				
				System.out.println(d);
				
				//to generate in dd-MM-yyy, but month always in uppercase only
				
				SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
				//to pass the object of date in the simpledatedateformat.
				sim.format(d);
				
				System.out.println(sim.format(d));
				
				//Now calculate date.
				
				Calendar cal = sim.getCalendar();
				
				//we have to add  30 days
				
				cal.add(Calendar.DAY_OF_MONTH, 30);
				
				//calculate date by using gettime method
				cal.getTime();
				
				System.out.println(cal.getTime());
				
				//Now we have to format date.
				
				String Expecteddate = sim.format(cal.getTime());
				
				System.out.println(sim.format(cal.getTime()));
				
		
		
		
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
		driver.findElement(By.name("campaignName")).sendKeys(Campaignname);
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("campaignStatus")).sendKeys(status);
		Thread.sleep(3000);
		driver.findElement(By.name("targetSize")).clear();
		
		driver.findElement(By.name("targetSize")).sendKeys(target_size);
		Thread.sleep(3000);
		
		driver.findElement(By.name("expectedCloseDate")).sendKeys(Expecteddate);
		
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Campaign xxxxxxxxxxx Successfully added
		//Verification
		
		WebElement msg = driver.findElement(By.xpath("//div[@role='alert']"));
		//Message is taking time to display, so we have to give  wait. so our element has to wait until the toastmsg is visible
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	//Hey driver please wait until the msg is visible.	
	wait.until(ExpectedConditions.visibilityOf(msg));
		
		String text = msg.getText();
		
		if(text.contains("Successfully Added"))
			
		{
			
			System.out.println("Campaign created");
		}

		
		else
		{
			
			System.out.println("Campaign not created");
		}
		
		//Closing the Message
		driver.findElement(By.xpath("(//button[@type='button']) [3]")).click();
		
		
		WebElement we = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		
		Actions a = new Actions(driver);
		
		a.moveToElement(we).perform();
		
		
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		
		driver.quit();
	}

	}


