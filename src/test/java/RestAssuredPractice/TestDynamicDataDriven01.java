package RestAssuredPractice;

import org.testng.annotations.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;

public class TestDynamicDataDriven01 extends TestDataParentClass {

		//@Test(dataProvider="dPost")
		public void Test_Post(String firstName, String lastName, int subjectId) {

			JSONObject request = new JSONObject();

			request.put("firstName", firstName);
			request.put("lastName", lastName);
			request.put("subjectID", subjectId);

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
		
		// Using Data Provider testNG annotation
		
		//@Test(dataProvider="dDelete")
		public void Test_Delete(int userId) {

			baseURI = "http://localhost:3000/";
			when().
				delete("/users/"+userId).
			then().
				statusCode(200).
				log().all();
		}
		
		// Using Parameter testNG annotation
		
		@Parameters({"userId"})
		@Test
		public void Test_Delete1(int userId) {

			System.out.println("The User ID is:"+userId);
			
			baseURI = "http://localhost:3000/";
			when().
				delete("/users/"+userId).
			then().
				statusCode(200).
				log().all();
		}

}