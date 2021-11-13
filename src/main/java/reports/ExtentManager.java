package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentReports reports;
	public static String screenShotsFolder;
	
	
	public static ExtentReports getReports() {
		
		if (reports == null) {
			reports = new ExtentReports();// This will initialize reports
			
			Date d = new Date();
			
			String path = d.toString().replaceAll(":", "-") +"//screenshots";
			
			 screenShotsFolder =  System.getProperty("user.dir") +"//reports//"+path;
			 String reportsFolder = System.getProperty("user.dir") +"//reports//"+d.toString().replaceAll(":", "-");
			 File f = new File(screenShotsFolder);
			 f.mkdirs();
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportsFolder);
			

			sparkReporter.config().setReportName("Automation Practice Test");
			sparkReporter.config().setDocumentTitle("Automation Reports");
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setEncoding("utf-8");
			
			reports.attachReporter(sparkReporter);	
			
		}
		
		return reports;
	}

}
