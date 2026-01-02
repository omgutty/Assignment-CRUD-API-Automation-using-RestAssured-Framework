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

public class BookingAPITest extends BaseTest{
	
	int bookingID;
	
	@Test (priority= 1,description="verify the new booking with post call ")
	public void CreateNewbookingTest() {
		
		// we have moved this into browser factory , and calling this directly in post call 
		//	Booking user= new Booking("OM", "Gutty", 101, true, "Breakfast", new Bookingdates("2018-01-01", "2019-01-01"));
		
		//we can call the method and pass that booking ref into post call as well. user
		Booking user= BookingFactory.generatebookingdata("om","Gutty");
		
		
		//spec method will call the reusable specification we have created in Base class, with @before call method , we have craeted a object of it.
		// we created utlity for post call, and passed specification, end point path in body, it will add after baseclass. in and body object 
		
		//BookingFactory.generatebookingdata()
		Response response= APIUtility
				.Post(req_specification, APIEndPoints.CREATE_BOOKING.getpath(), user);
		
		
		//Q- req_specification is ref is passing here, 
		// can you explain me this ?
		//in apiutlity we are already passing this RequestSpecification, bit confused at this statment 
		
		//after post, we will then and get lot, so below after post, response, start with then and to get the respon with log, we used spec
		response.then().spec(res_specification);
		
		//System.out.println(response.then().spec(res_specification));
		bookingID=response.jsonPath().get("bookingid");
		System.out.println("Booking ID: "+bookingID);
		
		Assert.assertEquals(response.getStatusCode(), 200,"Response is not matched.");
		
		
	}
	
	
	
	
	@Test(priority= 2,description="verify the update booking  ")
	public void updatebooking () {
		
		
	
		Booking user= BookingFactory.generatebookingdata("kittu","chetan");
		//we can careate hashmap object and pass the parameters
		//HashMap<String	, Object	> s= new HashMap<String, Object>();
		
		//we have a called Map interface , by using this, we can pass key values directly introduced in java 9 and stored with reference 
		
		//in utility we create one empty map, if any paramters are passing null value, which means for that request, if path param or query param is not sending. 
		// to manage that, we are creating one empty map 
		
		Map<String, Object> pathparameter= Map.of("id", bookingID);
		Map<String, Object> queryparam= Map.of();
		Map<String, Object> headers= Map.of("Content-Type","application/json","Accept","application/json","Cookie","token="+Tokenmanager.gettoken());
		
		
		
		Response response=APIUtility.put(req_specification, APIEndPoints.UPDATE_BOOKING.getpath(), user, pathparameter,  headers,queryparam);
		response.then().spec(res_specification);
		
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	
	@Test(priority= 3,description="verifying the delete booking  ")
	public void deletebooking () {
		
		Map<String, Object> pathparameter= Map.of("id", bookingID);
		Map<String, Object> queryparam= Map.of();
		Map<String, Object> headers= Map.of("Content-Type","application/json","Cookie","token="+Tokenmanager.gettoken());
		Response response= APIUtility.delete(req_specification, APIEndPoints.DELETE_BOOKING.getpath()	, pathparameter , headers, queryparam);
		response.then().spec(res_specification);
		Assert.assertEquals(response.getStatusCode(), 201);	
		
	}
		
		
	
		
	
	
	/*@Test (description="verify the new booking with post call- pass the payload from json file  ")
	public void CreateNewBookingTestwithJsonFile() {
		
		File payload= new File("src/test/resources/jsondata/SingleuserBooking.json");
		
		Response response= APIUtility
				.Post(req_specification, APIEndPoints.CREATE_BOOKING.getpath(), payload);
		response.then().spec(res_specification);
		Assert.assertEquals(response.getStatusCode(), 200,"Response is not matched.");
		
	}
	*/
	

}
