package requests.get;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class QueryParamExample {
	
	String id="2";
	
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath="/api";
	}
	
	@Test
	public void getUser() {
		Response res =
		given()
			.pathParam("id",id)
		.when()
			.get("/users/{id}");
		/*then()
			.statusCode(200);*/
		
		System.out.println(res.body().asPrettyString());
	}

}
