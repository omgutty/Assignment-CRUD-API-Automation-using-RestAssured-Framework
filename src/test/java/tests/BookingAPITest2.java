package tests;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import auth.Tokenmanager;
import base.BaseTest;
import enums.APIEndPoints;
import factory.BookingFactory;
import io.restassured.response.Response;
import models.Booking;
import models.Booking.Bookingdates;
import utlity.APIUtility;

public class BookingAPITest2 extends BaseTest{
	
	int bookingID;
	
	@Test (priority= 1,description="verify the new booking with post call ")
	public void CreateNewbookingTest() {

		Booking user= BookingFactory.generatebookingdata("om","Gutty");
		Response response= APIUtility
				.Post(req_specification, APIEndPoints.CREATE_BOOKING.getpath(), user);
		response.then().spec(res_specification);
		bookingID=response.jsonPath().get("bookingid");
		System.out.println("Booking ID: "+bookingID);
		Assert.assertEquals(response.getStatusCode(), 200,"Response is not matched.");
	}
	
	@Test(priority= 2,description="verify the update booking  ")
	public void updatebooking () {
		
		Booking user= BookingFactory.generatebookingdata("kittu","chetan");
				
		Map<String, Object> pathparameter= Map.of("id", bookingID);
		
		Map<String, Object> headers= Map.of
				("Content-Type","application/json","Accept","application/json","Cookie","token="+Tokenmanager.gettoken());
				
		Response response=APIUtility.put(req_specification, APIEndPoints.UPDATE_BOOKING.getpath(), user, pathparameter,  headers,null);
		response.then().spec(res_specification);
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
		
	@Test(priority= 3,description="verifying the delete booking  ")
	public void deletebooking () {
		
		Map<String, Object> pathparameter= Map.of("id", bookingID);
		
		Map<String, Object> headers= Map.of("Content-Type","application/json","Cookie","token="+Tokenmanager.gettoken());
		Response response= APIUtility.delete(req_specification, APIEndPoints.DELETE_BOOKING.getpath()	, pathparameter , headers, null);
		response.then().spec(res_specification);
		Assert.assertEquals(response.getStatusCode(), 201);	
	}
		
}
