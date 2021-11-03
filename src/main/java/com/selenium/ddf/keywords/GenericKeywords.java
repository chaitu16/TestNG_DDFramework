package com.selenium.ddf.keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class GenericKeywords extends UtilityKeywords{
	
	
	public WebDriver openBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs/chrome.log");
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions crops = new ChromeOptions();
			//crops.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			crops.addArguments("--disable-notifications");
			crops.addArguments("--start-maximized");
			crops.addArguments("ignore-certificate-erors");			
			
			driver = new ChromeDriver(crops);
			
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "logs/firefox.log");
			
			FirefoxOptions fop = new FirefoxOptions();
			//fop.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			FirefoxProfile fProfile = new FirefoxProfile();
			fProfile.setPreference("dom.webnotifications.enabled", false);
			fop.setProfile(fProfile);
			
			driver = new FirefoxDriver(fop);
			
		}else if(browserName.equalsIgnoreCase("Edge")) {
			//System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY,"logs\\edge.log");
			//System.setProperty(EdgeDriverService.EDGE_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			
			EdgeOptions options = new EdgeOptions();
			//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//options.setBinary(new File(""));
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			//options.addArguments("ignore-certificate-errors");
			
			driver = new EdgeDriver(options);
		}else if(browserName.equalsIgnoreCase("ie")) {
			//System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGLEVEL_PROPERTY, "INFO");
			//System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "logs\\ie.log");
			//System.setProperty(InternetExplorerDriverService.IE_DRIVER_SILENT_PROPERTY, "true");
			
			InternetExplorerOptions options = new InternetExplorerOptions();
			//options.setBinary
			//options.setPageLoadStrategy(strategy)
			//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			/*String proxy="82.288.287.22:8080";
			Proxy p = new Proxy();
			p.setAutodetect(false);
			p.setProxyType(Proxy.ProxyType.MANUAL);
			p.setSocksProxy(proxy);
			
			*/
			
			//cap.setCapability(CapabilityType.PROXY, p);			
			options.merge(cap);				
			driver = new InternetExplorerDriver();
		
		
	}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
}
	
		
		public void navigate(String url) {
			driver.get(getElement(url));
		}
		
		public void click(String locator) {
			findDriverElement(locator).click();
		}
		
		public void inputText(String locator, String data) {
			findDriverElement(locator).sendKeys(getElement(data));
		}		
		
		public void selectItem(String locator, String data) {
			WebElement ele = findDriverElement(locator);
			List<WebElement> sizes = ele.findElements(By.cssSelector(getElement("size_list_css")));
			System.out.println(sizes.size());
			
			for(int i =0; i<sizes.size();i++) {
				System.out.println(sizes.get(i).getText());
				if(data.equals(sizes.get(i).getText())) {
					sizes.get(i).click();
				}
			}
			
		}
		

}
