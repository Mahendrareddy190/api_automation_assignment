package ApiAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;


public class automation {
	Response id;
	
	@Test
	void Create_POST() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("city", "lagos");
		given().contentType("application/json").body(data)
		.when().post("https://countriesnow.space/api/v0.1/countries/population/cities").then().statusCode(301);
		
		when().get("https://countriesnow.space/api/v0.1/countries/population/cities/q?city=lagos")
		.then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchema(new File("/Users/perammahendrareddy/Documents/Api_Automation/ApiAutomation/src/test/java/ApiAutomation/post_validation.json")))
		.and().body("data.city", equalTo("Lagos")).and().body("data.country",equalTo("Nigeria")).log().all();
	
	}
	
	@Test
	void Create_GET() {
		given()
		.when().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02")
		.then().statusCode(200).body("base",equalTo("stations")).body("name",equalTo("London")).and().assertThat().body(JsonSchemaValidator.
			      matchesJsonSchema(new File("/Users/perammahendrareddy/Documents/Api_Automation/ApiAutomation/src/test/java/ApiAutomation/validation.json"))).log().all();		
	}
}
