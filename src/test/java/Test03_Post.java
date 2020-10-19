import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test03_Post {
	
	@Test
	public void Test_03() {
		
		//We can either use Map or JSON Object to Post 
		
		//Using Map (1)
		
		//Map<String, Object> map = new HashMap<String,Object>();
		
		//escape character "\"
		
		//map.put("\"name\"", "\"Syed\"");
		
		//map.put("name", "Syed");
		//map.put("job", "Student");
		
		//System.out.println(map);
		
		//Using JSON Object (2)
		
		JSONObject req = new JSONObject();
		
		req.put("name", "Syed");
		req.put("job", "Student");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
		
		
		given().
				header("Content-Type", "Application/JSON").
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
				body(req.toJSONString()).
		when().
				post("https://reqres.in/api/users").
		then().
				statusCode(201);
		
		
	}

}
