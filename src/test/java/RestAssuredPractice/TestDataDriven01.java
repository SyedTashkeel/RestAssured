package RestAssuredPractice;

import org.testng.annotations.*;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestDataDriven01 {

	@DataProvider(name ="dPost")
	public Object[][] dataForPost(){
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "Zoya";
		data[0][1] = "Syeda";
		data[0][2] = 1;

		data[1][0] = "Ahmed";
		data[1][1] = "Syed";
		data[1][2] = 2;
		
		return data;
		
	}
	
		@Test(dataProvider="dPost")
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
}
