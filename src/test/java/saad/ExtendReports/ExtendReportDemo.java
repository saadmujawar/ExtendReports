package saad.ExtendReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
     
public class ExtendReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automatio Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saad");
		
		
		
	}
	
	@Test
	public void initialDemo()
	{
		
		extent.createTest("Initial Demo");
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		extent.flush();
	}

}
