package requests.get;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class QueryParamExample {
	
	//String id="2";
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
	}
	
	@Test
	public void createUser() {
		Response res =
		given()
			.headers("content-type", "application/json")
			.body("{\n" + 
					"    \"name\": \"morpheus\",\n" + 
					"    \"job\": \"leader\"\n" + 
					"}")
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.extract().response();
		
		System.out.println(res.body().asPrettyString());
	}

}
