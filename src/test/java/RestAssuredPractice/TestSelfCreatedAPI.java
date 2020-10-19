package RestAssuredPractice;

import org.testng.annotations.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class TestSelfCreatedAPI {

	//@Test
	public void Test_Get() {

		baseURI = "http://localhost:3000/";

		given().
		param("name","Automation").
		get("/subjects").
		then().
		statusCode(200).
		log().all();
	}

	//@Test
	public void Test_Post() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Today");
		request.put("lastName", "Yday");
		request.put("subjectID", "2");

		baseURI = "http://localhost:3000/";

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();

	}
	
	//@Test
	public void Test_Patch() {

		JSONObject request = new JSONObject();

		request.put("lastName", "why?");

		baseURI = "http://localhost:3000/";

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
			patch("/users/5").
		then().
			statusCode(200).
			log().all();

	}

	//@Test
	public void Test_Put() {

		JSONObject request = new JSONObject();

		request.put("firstName", "Jan");
		request.put("lastName", "Feb");
		request.put("subjectID", "1");

		baseURI = "http://localhost:3000/";

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
			put("/users/5").
		then().
			statusCode(200).
			log().all();

	}

	@Test
	public void Test_Delete() {

		baseURI = "http://localhost:3000/";
		when().
			put("/users/5").
		then().
			statusCode(200).
			log().all();

	}

}
