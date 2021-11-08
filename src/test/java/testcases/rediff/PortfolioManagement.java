package testcases.rediff;

import org.testng.annotations.Test;

import com.selenium.ddf.keywords.ApplicationKeywords;

import testbase.BaseTest;
import testcases.rediff.Session;

public class PortfolioManagement extends BaseTest {
	
	@Test()
	public void createPortfolio() {	
		
		
		app.click("create_btn_css");
		System.out.println("Create portfolio");
	}
	
	
	@Test
	public void deletePortfolio() {
	
		System.out.println("Delete portfolio");
	}
	

}
