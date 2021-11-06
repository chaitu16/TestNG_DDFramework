package hotelbooking;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookHotel {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("---------------Start Test-------------------");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("---------------End Test----------------------");
	}
	
	@Test
	public void searchHotel() {		
		System.out.println("Searched hotel online\n");		
	}
	
	@Test
	public void selectHotel() {
		System.out.println("Selected Hotel\n");
	}
	
	@Test
	public void bookingComplete() {
		System.out.println("Booking process Completed !\n");
	}

}
