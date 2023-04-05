package common_method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class post_common_method {
	
	public static int StatusCodeExtractor(String baseURI, String resource, String requestbody)
	{
		RestAssured.baseURI =baseURI;
		int StatusCode =given().header("Content-Type", "application/json").body(requestbody).
				when().post(resource).then().extract().statusCode();
		return StatusCode;
	}
	
	public static String responseBodyExtractor (String baseURI, String resource, String requestbody)
	{
		String responseBody =given().header("Content-Type", "application/json").body(requestbody).
				when().post(resource).then().extract().response().asString();
		return responseBody;
	}

}
