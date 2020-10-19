import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Test04_Put {

	@Test
	public void test_04() {
		
		JSONObject rput = new JSONObject();
		
		rput.put("name", "Syed");
		rput.put("job", "Learner");
		
		System.out.println(rput);
		System.out.println(rput.toJSONString());
		
		given().
				header("Content-Type","Application/JSON").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				body(rput.toJSONString()).
					when().
				put("https://reqres.in/api/users/2").
					then().
				statusCode(200).
					log().all();
		
		
	}
	
}
