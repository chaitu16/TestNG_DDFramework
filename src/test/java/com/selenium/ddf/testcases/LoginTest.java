package com.selenium.ddf.testcases;

import com.selenium.ddf.keywords.GenericKeywords;
import com.selenium.ddf.keywords.UtilityKeywords;
import com.selenium.ddf.keywords.ValidationKeywords;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.ddf.keywords.ApplicationKeywords;

public class LoginTest extends  ApplicationKeywords  {
	
	
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
		
		openBrowser("chrome");
		navigate("url");
		inputText("useremail_id","useremail");
		inputText("password_id","password");
		click("submit_id");
		
		
		
	}

}
