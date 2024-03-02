package RestAssured_API_demo.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class post_req {
	@Test
	public void postRequest() {
		RestAssured.baseURI="https://reqres.in/api/users";
		
		String s = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		//pre-condition
		given().body(s).
		//action
		when().post().
		//post
		then().log().all().assertThat().statusCode(201);
		
	}
}
