package utlity;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import enums.APIEndPoints;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtility {
	
	public static Response Post(RequestSpecification reqsep, String path, Object paylload) {
		Response resp= given().spec(reqsep)
				.body(paylload) 
				
				.when()
				.post(path);
		return resp;
	}
	
	public static Response Post(RequestSpecification reqsep, String path, String paylload) {
		Response resp= given().spec(reqsep)
				.body(paylload) 
				.when()
				.post(path);
		return resp;
	}
	
	public static Response Post(RequestSpecification reqsep, String path, File paylload) {
		Response resp= given().spec(reqsep)
				.body(paylload) 
				.when()
				.post(path);
		return resp;
	}

	/*public static Response put(RequestSpecification reqsep, String path, Object payload, String pathparam, Headers header, Cookies cookies) {
		Response resp= given()
				.spec(reqsep)
				.headers(header)
				.body(payload) 
				.when()
				.post(path);
		return resp;
	}*/
	
	public static Response put(RequestSpecification reqsep, String path, Object payload, Map<String, Object> pathparam, Map<String, Object> header,Map<String, Object> query) 
	{
				Response response=given()
				.spec(reqsep)
				//if headers is not equal to null (?)then use headers , : If not use Maps.of empty 
				//? conditional operator if it is not null, check, if null use another 
				.headers(header!=null ? header: Map.of())
				.pathParams(pathparam!=null ? pathparam:Map.of())
				.queryParams(query!=null ? query : Map.of() )
				.body(payload)
				.when()
				.put(path);
				
				return response;
				
	}
	
	//creating overloaded method with different arguments
	public static Response put(RequestSpecification reqsep, String path, Object payload, Map<String, Object> pathparam, Map<String, Object> header) 
	{
				Response response=given()
				.spec(reqsep)
				.headers(header!=null ? header: Map.of())
				.pathParams(pathparam!=null ? pathparam:Map.of())
				.body(payload)
				.when()
				.put(path);
				return response;	
	}
	public static Response put(RequestSpecification reqsep, String path, Object payload,  Map<String, Object> header) 
	{
				Response response=given()
				.spec(reqsep)
				.headers(header!=null ? header: Map.of())
				.body(payload)
				.when()
				.put(path);
				return response;	
	}
	public static Response put(RequestSpecification reqsep, String path, Object payload) 
	{
				Response response=given()
				.spec(reqsep)
				.body(payload)
				.when()
				.put(path);
				return response;	
	}
	
	//in utility we create one empty map, if any paramters are passing null value, which means for that request, if path param or query param is not sending. 
	// to manage that, we are creating one empty map 
	
	public static Response delete(RequestSpecification reqsep, String path,  Map<String, Object> pathparam, Map<String, Object> header,Map<String, Object> query) 
	{
				Response response=given()
				.spec(reqsep)
				.headers(header!=null ? header:Map.of())
				.pathParams(pathparam!=null ? pathparam:Map.of())
				.queryParams(query!=null ? query:Map.of())
				
				.when()
				.delete(path);
				
				return response;
				
	}
	
}
