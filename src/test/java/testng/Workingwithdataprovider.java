package testng;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.Login2;
import POM.homepage;
import POM.loginpage;
import genericutilities.excelgenericutility;
import genericutilities.webdriverutility;

public class Workingwithdataprovider {

	
	@Test(dataProvider = "loginDetails")
	public void login(String username,String password) throws IOException
	{
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		WebDriver driver=new ChromeDriver();
		webdriverutility web=new webdriverutility();
		driver.manage().window().maximize();
		web.impcitwait(driver);
		
		loginpage lp=new loginpage(driver);
		lp.loginapp("http://49.249.28.218:8098", username,password);
		
		homepage hp=new homepage(driver);
		hp.logout();
		driver.quit();
		
		
	}
	
	@DataProvider
	public  Object[][] loginDetails() throws IOException {
		
		Object [][] objArr=new Object[5][2];	
	//	objArr[0][0]="rmgyantra";
		//objArr[0][1]="rmgy@9999";
		//objArr[1][0]="rmgyantra";
	//	objArr[1][1]="rmgy@9999";
		//objArr[2][0]="rmgyantra";
		//objArr[2][1]="rmgy@9999";
		//objArr[3][0]="rmgyantra";
		//objArr[3][1]="rmgy@9999";
		//objArr[4][0]="rmgyantra";
		//objArr[4][1]="rmgy@9999";
		
		excelgenericutility eu=new excelgenericutility();
		
		for(int i=1;i<eu.getrowcount("Dataprovider");i++)
		{
			objArr[i-1][0]=eu.togetdatafromexcelfiles("Dataprovider", i, 0);
			objArr[i-1][1]=eu.togetdatafromexcelfiles("Dataprovider", i, 1);
		}
		
		return objArr;
	
	}
}
