package testbase;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.ddf.keywords.ApplicationKeywords;

import reports.ExtentManager;

public class BaseTest {
	
	public ExtentReports reports;
	public ExtentTest test;
	
	public ApplicationKeywords app;

	@BeforeTest(alwaysRun=true)
	public void beforeTest(ITestContext context) {
		System.out.println("Before Test");
		
		app= new ApplicationKeywords(test);
		context.setAttribute("app", app);
		reports = ExtentManager.getReports();
		test = reports.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Test Name is : "+ context.getCurrentXmlTest().getName());
		
		context.setAttribute("reports", reports);
		context.setAttribute("test", test);	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(ITestContext context) {
		System.out.println("Before Method");
		
		 app = (ApplicationKeywords) context.getAttribute("app");
		 reports = (ExtentReports) context.getAttribute("reports");
		 test = (ExtentTest) context.getAttribute("test");
	}
	
	@AfterTest
	public void quit() {
		System.out.println("After Test");
		if(reports != null) {
			reports.flush();
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	

}
