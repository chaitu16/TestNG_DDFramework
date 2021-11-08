package com.selenium.ddf.testcases;

import com.selenium.ddf.keywords.GenericKeywords;
import com.selenium.ddf.keywords.UtilityKeywords;
import com.selenium.ddf.keywords.ValidationKeywords;

import testbase.BaseTest;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.selenium.ddf.keywords.ApplicationKeywords;

public class LoginTest extends  BaseTest  {
	
	@Test	
	// @Parameters({"browser","url"})
	//public void loginTest(@Optional("Browser and url")String browser,@Optional("hello")String url) {
	
		public void loginTest() {
//		ApplicationKeywords app = new ApplicationKeywords();
//		openBrowser("firefox");
//		navigate("URL");
//		click("size_button_xpath");
//		Thread.sleep(3000);
//		selectItem("ul_list_css", "38.5");
		
		app.openBrowser("chrome");
		app.navigate("url");
		app.inputText("useremail_id","useremail");
		app.inputText("password_id","password");
		app.click("submit_id");
		
		
		
	}

}
