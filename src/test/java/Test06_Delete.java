import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test06_Delete {

	@Test
	public void Test_06() {
		
		given().
			when().
		delete("https://reqres.in/api/users/2").
			then().
		statusCode(204).
			log().all();
	}
}
