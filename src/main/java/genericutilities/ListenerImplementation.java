package genericutilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener, ISuiteListener {

	public ExtentReports report = new ExtentReports();// will generate the report
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration, this should be the execute before suite");
		// configure
		javautility ju = new javautility();
		// automatically folder created
		ExtentSparkReporter espark = new ExtentSparkReporter(
				"./ExtentReports/report" + ju.generateCurrentDateandTime() + ".html");
		espark.config().setDocumentTitle("CRM Reports");
		espark.config().setReportName("Ninja CRM Report");
		// Theme is a enum
		espark.config().setTheme(Theme.DARK);

		report.attachReporter(espark);// we are attching configuration in report.
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");

	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Report Backup, this should be the execute After suite");
		// To store the report.
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// result dig out, to fetch testcasename.
		String testcase = result.getMethod().getMethodName();
		// System.out.println(testcase+" execution started");
		test = report.createTest(testcase);
		// instead of SOP, we use log, to print only in report.
		test.log(Status.INFO, testcase + " execution started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		// System.out.println(testcase+" execution Success");
		test.log(Status.PASS, testcase + " execution Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		// System.out.println(testcase+" execution fail");
		test.log(Status.FAIL, testcase + " execution fail");
		javautility ju = new javautility();
		TakesScreenshot ts = (TakesScreenshot) Baseclass.sdriver;
		// File temp = ts.getScreenshotAs(OutputType.FILE);
		// File dest = new File("./ErrorSS/"+
		// testcase+ju.generateCurrentDateandTime()+".png");
		

		// try {
		// org.openqa.selenium.io.FileHandler.copy(temp, dest);
		// } catch (IOException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		
		// in extentreport, want to take ss of failed SS, so we Base64, because it
				// supports this only.
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testcase = result.getMethod().getMethodName();
		// System.out.println(testcase+" execution skip");
		test.log(Status.SKIP, testcase + " execution skip");

	}

}
