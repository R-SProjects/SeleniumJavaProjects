package ExtentReports.Rah;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRep {
	ExtentReports extent;
	@BeforeTest
	public void configdemo() {
		//ExtendReports,ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAuto");
		reporter.config().setDocumentTitle("New TiTle");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Roopa");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test =extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		System.out.println("InitialDemo");
		System.out.println(driver.getTitle());
		System.out.println("Got the report");
		test.fail("Results not match");
		extent.flush();
	}

}
