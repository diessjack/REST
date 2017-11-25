/**
 * 
 */
package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovyjarjarantlr.collections.List;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.PlaceAddModel;

/**
 * @author HAOSHU FENG
 * @version 1.0
 * @since Nov 10, 2017 7:01:50 AM 
 */
public class PostDemo {
	
	@BeforeClass
	public void setup(){
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}
  @Test 
  
  public void status() {
	  Map<String , Double> locationMap = new HashMap<String, Double>();
	  locationMap.put("lat", -33.8669710);
	  locationMap.put("lng", 151.1958750);
	  
	  ArrayList<String> type = new ArrayList<String>();
	  type.add("shoe_store");
	  
	  PlaceAddModel pl = new PlaceAddModel();
	  pl.setLocation(locationMap);
	  pl.setName(type.get(0)); // or pl.setName("Google Shoes!") if bug come up.
	  pl.setPhone_number("(02) 9374 4000");
	  pl.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
	  pl.setTypes(type);
	  pl.setWebsite("http://www.google.com.au/");
	  pl.setLanguage("en-AU");
	 // Response resp = 
	  given()
	  	.queryParam("key", "AIzaSyBJfLdRqopbriU-YAHYTRHv2V02RGJJ3vw")
	  	.body(pl
	  			//jackson or gson -> they converts the object into JSON format.
	  			)
	  .when()
	  	.post("/place/add/json")
	 // System.out.println(resp.body().asString());
	  .then()
	  	.statusCode(200)
	  	.contentType(ContentType.JSON)
	  	.and().body("scope", equalTo("APP"));
  }
}
