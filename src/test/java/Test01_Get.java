import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class Test01_Get {

	@Test
	void Test_01() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getHeader("Content-Type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);				
				
	}
	
	@Test
	void Test_02() {
		
		given()
			.get("https://reqres.in/api/users?page=2")
			.then()
			.body("data.id[0]", equalTo(7))
			.statusCode(200);
		
	}

	
}
