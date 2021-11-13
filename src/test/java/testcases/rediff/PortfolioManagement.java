package testcases.rediff;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.selenium.ddf.keywords.ApplicationKeywords;

import testbase.BaseTest;
import testcases.rediff.Session;

public class PortfolioManagement extends BaseTest {
	
	@Test()
	public void createPortfolio(ITestContext context) {	
		//app.defaultLogin();
		
		app.click("create_btn_css");
		app.clear("prtflio_name_css");
		app.inputText("prtflio_name_css", "portfilo_name");
		app.click("create_portflio_btn_css");
		
		System.out.println("Create portfolio");
		app.log("add portfolio screenshot");
	}
	
	
	@Test
	public void deletePortfolio(ITestContext context) {
		app.defaultLogin();
		
		app.selectList("delete_port_css", 5);
		app.click("del_prt_id");
		app.acceptAlert();	
		app.log("remove portfolio screenshot");
	
		System.out.println("Delete portfolio");
	}
	

}
