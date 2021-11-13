package testcases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import testbase.BaseTest;


public class Session extends BaseTest {
	
	@Test
	public void doLogin(ITestContext context) {
		
		app.defaultLogin();
		
	/*	app.openBrowser("firefox");
		app.navigate("url");
		app.inputText("useremail_id","useremail");
		app.inputText("password_id","password");
		app.click("submit_id");	
				
	//	app.reportFail("Fail Test");	
	//	app.assertAll();
	 * 
	 */
	}
	
	
	
	@Test
	public void doLogout() {
		
	}

}

