package Framework.ExtentReportsnew;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EXTRENTR {
	ExtentReports extent;
	@BeforeTest
	public void before() {
		//ExtentReports
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("TestResults");
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "SARAN");
	}
	@Test
	
	public void Demo() {
		ExtentTest test = extent.createTest("Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sys1\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.close();
		test.addScreenCaptureFromBase64String("Test Pass");
		extent.flush();
	}
}


