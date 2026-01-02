package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.Booking.Bookingdates;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddObject {
	
	public String name;
	public data data;
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class data {

		public int year;
		public double price;
		public String CPUmodel;
		public String Harddisksize;
		

	}

}
