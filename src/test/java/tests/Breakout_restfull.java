package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseTest;
import enums.APIEndPoints;
import factory.ObjectFactory;
import io.restassured.response.Response;
import models.AddObject;
import models.UpdateObject;
import utlity.APIUtility;

public class Breakout_restfull extends BaseTest {
	
	String  bookingid;
	
	
	@Test (priority= 1,description="verify Create Object - Post call ")
	public void CreateObject() {
		
		AddObject object= ObjectFactory.generateresutfullobjectdata();
		
		Response response= APIUtility.Post(req_specification,APIEndPoints.CREAT_OBJECT.getpath(), object);
		response.then().spec(res_specification);
		bookingid=response.jsonPath().get("id");
		ChainTestListener.log("Booking ID : "+bookingid);
		String createdAt=response.jsonPath().get("createdAt");
		ChainTestListener.log("Response Created at :"+createdAt);
		Assert.assertNotNull(createdAt, "createdAt tag is null in response");
	}
	
	@Test(priority=2 , description="updating the created object - put call")
	public void updateObject() {
		/*
		 * AddObject object= ObjectFactory.generateresutfullobjectdata();
		 * object.data.setPrice(2049.99);
		 */
		
		UpdateObject update= ObjectFactory.updaterestfullobjectdata();
		//update.data.setPrice(2049.99);
		
		Map<String, Object> pathparameter= Map.of("id", bookingid);
		
		Response response= APIUtility.put(req_specification, APIEndPoints.UPDATE_OBJECT.getpath(),update,pathparameter,null,null);
		response.then().spec(res_specification);
		double updatedprice=response.jsonPath().getDouble("data.price");
		
		String coulour=response.jsonPath().get("data.color");
		ChainTestListener.log("Response data object color : "+response.jsonPath().get("data.color"));
		String updatedAt=response.jsonPath().get("updatedAt");
		ChainTestListener.log("Response Updated At : "+response.jsonPath().get("updatedAt"));
		Assert.assertNotNull(updatedAt, "updatedAt tag is null in response");
		Assert.assertEquals(updatedprice, 2049.99, "Price is not updated");
		Assert.assertEquals(coulour, "silver","colour tag is mismatched");
	}
	
	@Test(priority=3,description="delete the object")
	public void DeleteObject() {
		
		Map<String, Object> pathparameter= Map.of("id", bookingid);
		Response response= APIUtility.delete(req_specification, APIEndPoints.DELETE_OBJECT.getpath(), pathparameter, null, null);
		
		response.then().spec(res_specification);
		String message=response.jsonPath().get("message");
		ChainTestListener.log(message);
		Assert.assertTrue(message.contains("Object with id = "+bookingid+" has been deleted."));
	}
	
	//already deleted product again trying to delete. what message it will give
	// try to create multiple product multiple times. 
	//Pass additional field which does not allow.
	
	
	

}
