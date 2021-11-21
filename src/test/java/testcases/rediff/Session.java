package testcases.rediff;

import java.util.Hashtable;
import java.util.Map;

import org.bouncycastle.asn1.dvcs.Data;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import testbase.BaseTest;
import util.Excel_Reader;
import util.TestDataUtil;


public class Session extends BaseTest {
	
	@Test(dataProvider="getData")
	public void doLogin(Map<String,String> data) {
		
		app.log(data.toString());
		if(data.get("Runmode").equals("N")) {
			test.log(Status.SKIP, "Skipped test");
		throw new SkipException("Testcase skipped");
		}
			app.openBrowser("firefox");
			app.navigate("url");
			app.inputText("useremail_id",data.get("email"));
			app.inputText("password_id",data.get("password"));
			
			app.click("submit_id");			
		}
		
		
	//	app.defaultLogin();
		
/*		app.openBrowser("firefox");
		app.navigate("url");
		app.inputText("useremail_id","useremail");
		app.inputText("password_id","password");
		app.click("submit_id");	
*/		
	//	app.reportFail("Fail Test");	
	//	app.assertAll();
		
	
	
	
	
	
	@Test
	public void doLogout() {
		
	}
/*	
	@DataProvider
	public Object[][] getData(){
		String path = System.getProperty("user.dir")+"\\data\\Test Data.xlsx";
		Excel_Reader read = new Excel_Reader(path);
		Object [][] data = TestDataUtil.getTestData( read, "Portfolio Suite", "Login Test");
		
		return data;
		
	}
	*/
	@DataProvider
	public Object[][] getData(){
		String path = System.getProperty("user.dir")+"\\data\\Test Data.xlsx";
		Excel_Reader read = new Excel_Reader(path);
		return new TestDataUtil().getTestData(read,"Portfolio Suite","Login Test");
			
	}

}

