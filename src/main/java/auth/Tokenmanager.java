package auth;

import com.nimbusds.openid.connect.sdk.AuthenticationRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tokenmanager {

	private static String token;
	
	public static String gettoken() {

		Authenticationrequest request = new Authenticationrequest("admin", "password123");

		if (token == null) {
			Response re = RestAssured.given().contentType(ContentType.JSON).body(request).when()
					.post("https://restful-booker.herokuapp.com/auth");

			token = re.jsonPath().getString("token");

		}
		return token;
	}
	
	
	
	}

