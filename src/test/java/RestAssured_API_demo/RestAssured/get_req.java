package RestAssured_API_demo.RestAssured;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class get_req {
	
	@Test
	public void getRequest() {
		RestAssured.baseURI="https://reqres.in/";
		//pre-condition
		given().queryParam("page",2).
		//action
		when().get().
		//post
		then().log().all().assertThat().statusCode(200);		
		
	}
	

}
