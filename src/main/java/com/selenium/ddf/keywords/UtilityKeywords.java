package com.selenium.ddf.keywords;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;


public class UtilityKeywords {
	
		WebDriver driver;
		Properties prop;
		ExtentTest test;
		SoftAssert softAssert;
		ExtentReports reports;
	 
	public WebElement findDriverElement(String locatorKey) {			
		
		WebElement element =null;
		
		try {
			
			By locator = getLocator(locatorKey);
			WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			element = driver.findElement(locator);
		
		}catch(Exception e) {
			e.getMessage();
		}		
		return element;		
	}	
	
	
	public String getElement(String key) {
		return prop.getProperty(key);
	}
	
		
	public By getLocator(String locatorKey) {
		
		By locator = null;
	
		if(locatorKey.endsWith("xpath")) {
			locator = By.xpath(getElement(locatorKey));
			
		}else if(locatorKey.endsWith("css")) {
			locator = By.cssSelector(getElement(locatorKey));
			
		}else if(locatorKey.endsWith("id")) {
			locator = By.id(getElement(locatorKey));
			
		}else if(locatorKey.endsWith("linktext")) {
			locator = By.linkText(getElement(locatorKey));
			
		}else if(locatorKey.endsWith("tagname")) {
			locator = By.tagName(getElement(locatorKey));
			
		}else if(locatorKey.endsWith("name")) {
			locator = By.name(getElement(locatorKey));
			
		}else if(locatorKey.endsWith("className")) {
			locator = By.className(getElement(locatorKey));
		}
		
		return locator;
	}	
	
	
	public void takeScreenShot() {
		// fileName of the screenshot
			Date d=new Date();
			String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
				// take screenshot
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					// store screenshot in screenshots folder
					FileUtils.copyFile(srcFile, new File(ExtentManager.screenShotsFolder+"//"+screenshotFile));
					//put screenshot file in reports
				    test.addScreenCaptureFromPath(ExtentManager.screenShotsFolder+"//"+screenshotFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void log(String logMsg) {
		test.log(Status.INFO, logMsg);
		takeScreenShot();
	}
	
	
	public void reportFail(String msg, boolean stop) {
		test.log(Status.FAIL, msg);
		takeScreenShot();
		softAssert.fail();
		if(stop) {
			assertAll();
		}
		
	}
	
	public void assertAll() {
		softAssert.assertAll();
	}
}
