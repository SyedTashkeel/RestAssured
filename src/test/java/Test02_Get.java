import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class Test02_Get {

	@Test
	public void Test_02() {
		
		given().
		get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).
		body("data.id[1]", equalTo(8)).
		body("data.first_name",hasItems("Michael","Tobias","George")).
		log().all();
				
	}

}
