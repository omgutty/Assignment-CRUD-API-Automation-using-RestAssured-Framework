package base;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeClass;

import com.aventstack.chaintest.plugins.ChainTestListener;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {
	public RequestSpecification req_specification;
	public ResponseSpecification res_specification;
	
	@BeforeClass
	public void setup() {
	
		ChainTestListener.log("LOG:: Setting up request specification and response specification for all API tests");
		//System.out.println("LOG:: Setting up request specification and response specification for all API tests");

		req_specification= new RequestSpecBuilder()
				 .log(LogDetail.ALL).setContentType(ContentType.JSON)
				 //.setBaseUri("https://restful-booker.herokuapp.com")
				 .setBaseUri(new  ConfigReader().get("baseURLofRestFull"))// baseURL for booking website
				 .build();
		
		 res_specification= new ResponseSpecBuilder()
				 .log(LogDetail.ALL)
				 //.expectContentType(ContentType.JSON)
				 .build();
		
	}
}
