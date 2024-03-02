package RestAssured_API_demo.RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class post_Json_req {
	@Test
	public void postRequest_json() {
		// RestAssured.baseURI="https://reqres.in/api/register";
		// CREATE
		RestAssured.baseURI = "https://reqres.in/api/users";

		JSONObject jsobj = new JSONObject();
		// input

		// "email": "eve.holt@reqres.in",
		// "password": "pistol"
		jsobj.put("name", "morpheus");
		jsobj.put("job", "leader");

		// pre-condition
		// object to String
		given().body(jsobj.toJSONString()).

		// action
		when().post().
		// post
		then().log().all().assertThat().statusCode(201);

	}
}
