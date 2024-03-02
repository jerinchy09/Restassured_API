package RestAssured_API_demo.RestAssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Delete_req {

	@Test
	public void delRequest() {
		//https://reqres.in/api/users/2
		
		//first delete the last updated data
		//put uri
		RestAssured.baseURI="https://reqres.in/api/users/2";
	
		JSONObject jsobj = new JSONObject();
		jsobj.put("name","morpheus");
		jsobj.put("job","zion resident");
		
		given().body(jsobj.toJSONString()).
		//action
		when().put().
		//post
		then().log().all().assertThat().statusCode(200);
		
		//delete
		given().body(jsobj.toJSONString()).
		//action
		when().delete().
		//post
		then().log().all().assertThat().statusCode(204);
	}
}
