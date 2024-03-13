package restassuredTests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;

public class TestCase02 {

	HashMap<String, String> data = new HashMap<String, String>();
	static String validateName, validateJobName; 
	@BeforeClass
	public void postData() {
		validateName = RestUtils.getName();
		validateJobName = RestUtils.getJobName();
		data.put("name",validateName);
		data.put("job", validateJobName);
		System.out.println("Name: "+ validateName);
		System.out.println("Job: "+ validateJobName);
		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users";
	}
	
	@Test
	public void testPost() {
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()
			.body("name", equalTo(validateName))
			.and()
			.body("job", equalTo(validateJobName));
	}
	
}
