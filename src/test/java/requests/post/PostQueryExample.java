package requests.post;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class PostQueryExample {
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
	}
	
	@Test
	public void getUsers() {
		given()
			.queryParam("page","x")
		.when()
			.get("/users")
		.then()
			.statusCode(200);
	}
}
