package hotelbooking;

import org.testng.annotations.Test;

public class PaymentMethods {
	
	@Test
	public void payonline() {
		System.out.println("Online payment process..\n");
	}
	
	@Test
	public void applyDiscount() {
		System.out.println("Apply discount on final Bill\n");
	}
	
	@Test
	public void payCash() {
		System.out.println("Paid by cash at hotel\n");
	}

}
