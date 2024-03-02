package RestAssured_API_demo.RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class put_req {

	@Test
	public void putRequest() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		//pre-condition

		JSONObject jsobj = new JSONObject();
		jsobj.put("name","morpheus");
		jsobj.put("job","zion resident");
		
		given().body(jsobj.toJSONString()).
		//action
		when().put().
		//post
		then().log().all().assertThat().statusCode(200);
		
		
	}
		
}
