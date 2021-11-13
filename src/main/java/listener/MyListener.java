package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListener implements  ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("test");
		
		test.log(Status.FAIL, result.getName());		
		test.log(Status.FAIL, "Listener------Test  Failed-----------! ");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		System.out.println("----Test Failed----"+result.getName()+result.getThrowable().getMessage());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("test");

		test.log(Status.SKIP, result.getTestName());
		System.out.println("Listener Skipped "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		
		ExtentTest test = (ExtentTest) result.getTestContext().getAttribute("test");

		test.log(Status.PASS, result.getTestName());
		System.out.println("Listener - Passed test is : "+result.getName());
	}

}
