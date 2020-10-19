import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test05_Patch {

	
	@Test
	public void Test_05() {
		
		JSONObject rpatch = new JSONObject();
		
		rpatch.put("name","Syed");
		rpatch.put("job","Tester");
		
		System.out.println(rpatch);
		System.out.println(rpatch.toJSONString());
		
		given().
			header("Content-Type","Application/JSON").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
			body(rpatch.toJSONString()).
				when().
			patch("https://reqres.in/api/users/2").
				then().
			statusCode(200).
				log().all();
		
		
	}
}
