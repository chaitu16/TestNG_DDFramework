package com.selenium.ddf.keywords;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityKeywords {
	
	 public static WebDriver driver;
	 public static Properties prop;
	
	 
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
		

}
