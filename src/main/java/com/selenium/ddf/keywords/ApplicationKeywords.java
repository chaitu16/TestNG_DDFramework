package com.selenium.ddf.keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;

public class ApplicationKeywords extends ValidationKeywords{		
	
	
	public ApplicationKeywords(ExtentTest test) {			
		
	try {				
		prop =new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//project.properties");
		prop.load(fis);		
	} catch (IOException e) {	
		e.printStackTrace();
	}	
	softAssert = new SoftAssert();	
	this.test = test;
}
	
	public void defaultLogin() {
		
		openBrowser("firefox");
		navigate("url");
		inputText("useremail_id","useremail");
		inputText("password_id","password");
		click("submit_id");	
		
	}

//	public void setReport(ExtentTest test) {
//		this.test = test;
//	}
}