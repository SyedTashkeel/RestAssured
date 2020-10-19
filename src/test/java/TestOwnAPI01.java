import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class TestOwnAPI01 {
	
	//@Test
	public void TestAPI01() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			param("Name","Automation").
			get("/subjects").
			then().
			statusCode(200).
			log().all();
		
		given().
		get("/users").
			then().
			statusCode(200).
			log().all();
				
	}

	// Adding record in db.json using put
	@Test
	public void TestPostAPI() {
		
		JSONObject rPost = new JSONObject();
		
		rPost.put("firstName","T2");
		rPost.put("lastName","S2");
		rPost.put("subjectId",2);
					
		baseURI ="http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","Application/JSON").
				body(rPost.toJSONString()).
			when().
				post("/users").
			then().
				statusCode(201).
			log().all();		
			
		
	}
	
	// updating record using patch
	//@Test
	public void TestPatchAPI() {
		
		JSONObject rput = new JSONObject();
		
		rput.put("lastName", "Khundmeer");
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type","Application/JSON").
				body(rput.toJSONString()).
			when().
				patch("/users/4").
			then().
				statusCode(200).
			log().all();
	}
	
	//@Test
	public void TestDeleteAPI() {
		
			RestAssured.baseURI = "http://localhost:3000/";
			 
	        Response response = null;
	 
	        try {
	            response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .delete("/users/3");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        System.out.println("Response :" + response.asString());
	        System.out.println("Status Code :" + response.getStatusCode());
	}
	
}
