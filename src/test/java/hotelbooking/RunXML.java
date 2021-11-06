package hotelbooking;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import runner.TestNGRunner;

public class RunXML {

	
	public static void main(String[] args) {
		
		TestNG tng = new TestNG();
		XmlSuite suite = new XmlSuite();
		suite.setName("Booking Suite");
		XmlTest test = new XmlTest(suite);
		test.setName("Test Booking @ NODiscount");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("hotelbooking.BookHotel"));
		
		
		classes.add(new XmlClass("hotelbooking.PaymentMethods"));
	
		test.setXmlClasses(classes) ;
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		tng.setXmlSuites(suites);
		tng.run(); 
		

	}

}
