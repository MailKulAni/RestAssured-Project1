package requests.get;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class PathParamExample {
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
	}
	
	@Test
	public void getUsers(){
	
		String response =
		given()
			.queryParam("page","x")
			//.log().all()
		.when()
			.get("/users")
		.then()
			//.log().all()
			.assertThat()
				.body("total",equalTo(12))
				.statusCode(200)
				
			.extract().response().asString();
				//.header("Age", equalTo(1695));
		
		JsonPath js = new JsonPath(response);
		String total_pages = js.getString("total_pages");
		System.out.println("total pages: "+total_pages);
	}
}
