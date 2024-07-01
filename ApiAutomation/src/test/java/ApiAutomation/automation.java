package ApiAutomation;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;


public class automation {
	 
	@Test
	void Create_GET() {
		given()
		.when().get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02")
		.then().statusCode(200).body("base",equalTo("stations")).body("name",equalTo("London")).and().assertThat().body(JsonSchemaValidator.
			      matchesJsonSchema(new File("/Users/perammahendrareddy/Documents/Api_Automation/ApiAutomation/src/test/resources/validation.json"))).log().all();		
	}
}
