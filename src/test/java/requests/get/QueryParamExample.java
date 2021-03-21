package requests.get;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class QueryParamExample {
	
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
