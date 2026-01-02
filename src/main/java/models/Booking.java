package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {

	public String firstname;
	public String lastname;
	public int totalprice;
	public boolean depositpaid;
	public String additionalneeds;
	public Bookingdates bookingdates;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Bookingdates {

		public String checkin;
		public String checkout;

	}

}
