package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	public productdata data;
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class productdata {

		public int year;
		public double price;
		//Q: with out this @jsonproperty also for me it worked. 
		@JsonProperty ("CPU model")//By using this, it will accept the space in key
		public String CPUmodel;
		@JsonProperty ("Harddisk size")
		public String Harddisksize;
		
		//when we say null, dot send , when i value send as a payload. 
		//So that we can use this add pojp for update object pojo instaead
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		public String color;
		

	}

}
