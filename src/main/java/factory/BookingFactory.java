package factory;

import models.Booking;
import models.Booking.Bookingdates;

public class BookingFactory {

	
	public static Booking generatebookingdata(String firstname, String lastname)
	{
		Booking user= new Booking(firstname, lastname, 101, true, "Breakfast", new Bookingdates("2018-01-01", "2019-01-01"));
		return user;
	}
	
	
}
