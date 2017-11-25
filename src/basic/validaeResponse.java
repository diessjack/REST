/**
 * 
 */
package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * @author HAOSHU FENG
 * @version 1.0
 * @since Nov 10, 2017 7:01:50 AM 
 */
public class validaeResponse {
	
	@BeforeClass
	public void setup(){
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
  @Test 
  
  public void status() {
	  given()
	  	.param("units", "imperial")
	  	.param("origins", "Washington,DC")
	  	.param("destinations", "New+York+City,NY")
	  	.param("key", "AIzaSyBJfLdRqopbriU-YAHYTRHv2V02RGJJ3vw")
	  .when()
	  	.get("/distancematrix/json")
	  .then()
	  	.statusCode(200)
	  	.and()
	  	.body("rows[0].elements[0].distance.text", equalTo("225 mi"))
	  	.contentType(ContentType.JSON);
  }
}
