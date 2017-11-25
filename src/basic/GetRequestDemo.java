package basic;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRequestDemo {
	
	@BeforeClass
	public void setup(){
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
  @Test(enabled = false)
  public void status() {
	  given()
	  	.param("units", "imperial")
	  	.param("origins", "Washington,DC")
	  	.param("destinations", "New+York+City,NY")
	  	.param("key", "AIzaSyBJfLdRqopbriU-YAHYTRHv2V02RGJJ3vw")
	  .when()
	  	.get("/distancematrix/json")
	  .then()
	  	.statusCode(200);
  }
  @Test
  public void getResponseBody() {
	  Response resp = 
	  given()
	  	.param("units", "imperial")
	  	.param("origins", "Washington,DC")
	  	.param("destinations", "New+York+City,NY")
	  	.param("key", "AIzaSyBJfLdRqopbriU-YAHYTRHv2V02RGJJ3vw")
	  .when()
	  	.get("/distancematrix/json");
	  System.out.println(resp.body().asString());
  }
}
