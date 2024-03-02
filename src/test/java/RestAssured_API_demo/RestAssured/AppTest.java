package RestAssured_API_demo.RestAssured;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.RestAssured;

public class AppTest 
{
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void setup() {
		report= new ExtentReports();
		ExtentSparkReporter sparkreport= new ExtentSparkReporter("E:\\Nexvalli\\Eclipse Wrokspace\\RestAssured_Api\\target\\report.html");
		test = report.createTest("RestAssured REquests");
		report.attachReporter(sparkreport);

	}
	
	@Test(priority=2)
	public void getRequest() {
		RestAssured.baseURI="https://reqres.in/";
		//pre-condition
		given().queryParam("page",2).
		//action
		when().get().
		//post
		then().log().all().assertThat().statusCode(200);	
		test.log(Status.PASS,"Get Request succesfull, priority 2");

		
	}
	@Test(priority=1)
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
		test.log(Status.PASS,"Post Request succesfull, priority 1");


	}
	@Test()
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
		test.log(Status.PASS,"Put Request succesfull");

		
	}
	
	@Test(dependsOnMethods= {"putRequest"})
	public void delRequest() {
		//https://reqres.in/api/users/2
		
		//first delete the last updated data
		//put uri
//		RestAssured.baseURI="https://reqres.in/api/users/2";
//	
		JSONObject jsobj = new JSONObject();
		jsobj.put("name","morpheus");
		jsobj.put("job","zion resident");
//		
//		given().body(jsobj.toJSONString()).
//		//action
//		when().put().
//		//post
//		then().log().all().assertThat().statusCode(200);
		
		//delete
		given().body(jsobj.toJSONString()).
		//action
		when().delete().
		//post
		then().log().all().assertThat().statusCode(204);
		test.log(Status.PASS,"Delete Request succesfull, depends on Put");

	}
	
	@AfterClass
	public void teardown() {
		this.report.flush();
		test.log(Status.PASS,"Framework closed");	
	}
	
}
