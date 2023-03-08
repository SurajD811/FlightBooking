package test;

import org.testng.annotations.Test;

import genrics.BaseTest;
import pagepackage.Flight_Booking;

public class Flight_Ticket_Booking extends BaseTest{
	
	@Test
	void bookFligtTicket() throws InterruptedException {
		Flight_Booking fb=new Flight_Booking(driver);
		fb.book_Spicejet_com();
	}
	
	

}
