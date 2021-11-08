package testcases.rediff;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import testbase.BaseTest;


public class Session extends BaseTest {
	
	@Test
	public void doLogin() {
		
		app.openBrowser("firefox");
		app.navigate("url");
		app.inputText("useremail_id","useremail");
		app.inputText("password_id","password");
		app.click("submit_id");		
		test.log(Status.INFO, "login test");
		app.log("login test");
		app.reportFail();
	//	app.assertAll();
	}
	
	
	
	@Test
	public void doLogout() {
		
	}

}

