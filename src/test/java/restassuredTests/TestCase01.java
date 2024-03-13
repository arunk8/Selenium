package restassuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class TestCase01 {

	@Test
	public void getUserDetails() {
		given() //inputs, user details
			.param("myname", "wertyuio")
			.header("headerdata","qwertyuio")
		.when() //conditon, steps
			.get("https://reqres.in/api/users?page=2")
		.then()  //validations
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.assertThat().body("page", equalTo(2))
		.log().all()
		.body("data.id", hasItems(8,9,10,11))
		.header("Content-Type", "application/json; charset=utf-8");
	}
}
