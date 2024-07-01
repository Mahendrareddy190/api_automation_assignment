package ApiAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class postautomation{
 
	
	@Test
	void Create_POST() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("year", "2000");
		data.put("limit", "10");
		data.put("it", "651348588");
		data.put("gt", "6513485");
		data.put("orderBy","name");
		data.put("order", "dsc");
		given().contentType("application/json").body(data)
		.when().post("https://countriesnow.space/api/v0.1/countries/population/filter").then().statusCode(301).log().all();
		
//		when().get("https://countriesnow.space/api/v0.1/countries/population/cities/q?city=lagos")
//		.then().assertThat()
//		.body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/perammahendrareddy/Documents/Api_Automation/ApiAutomation/src/test/java/ApiAutomation/post_validation.json")))
//		.and().body("data.city", equalTo("Lagos")).and().body("data.country",equalTo("Nigeria")).log().all();
	
	}
	
}
