package restassuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestCase03 {

	public HashMap<String, String> data = new HashMap<String, String>();
	String empName = RestUtils.getName();
	String empSalary = RestUtils.getSalary();
	String empAge = RestUtils.getAge();
	static int empId = 6;
	
	@BeforeClass
	public void getData() {
		data.put("name", empName);
		data.put("salary", empSalary);
		data.put("age", empAge);
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
	}
	
	@Test
	public void testPost() {
		RestAssured.basePath = "/update/"+empId;
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test
	public void deleteRecord() {
		RestAssured.basePath = "/delete/"+empId;
		Response response = given().when().delete().then().statusCode(200).log().all().statusLine("HTTP/1.1 200 OK").extract().response();
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! Record has been deleted"), true); 
		
	}
}
