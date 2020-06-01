package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.API_Resources;
import resources.Json_Data;
import resources.Utils;

public class Steps extends Utils {
	RequestSpecification request;
	Response response;
	Json_Data data = new Json_Data();
	static String place_id;
	
	@Given("the location with latidude {double} , longitude {double} and address {string}")
	public void a_location_with_latidude_longitude_and_address(double lat, double lng, String address) throws IOException {	
		request = given().spec(requestSpecification()).body(data.addPlacePayLoad(lat, lng, address));
	}
	
	@Given("an already created location")
	public void an_already_created_location() throws IOException {
		request = given().spec(requestSpecification());
	}

	@When("a user {string} the map")
	public void a_user_the_map(String action) {	
		API_Resources resAPI = API_Resources.valueOf(action);
		
		if(action.contains("add")) {
			response = request.when().post(resAPI.getResourse());
			place_id = getJsonPath(response, "place_id");
			System.out.println("Creating a new location");
		} else if(action.contains("gets")) {
			response = request.queryParam("place_id", place_id).when().get(resAPI.getResourse());
			System.out.println("Validating the location");
		} else if(action.contains("delete")) {
			response = request.body(data.delete_Location(place_id)).when().delete(resAPI.getResourse());
			System.out.println("Deleting the location");
		}
	}

	@Then("{string} {string} on response confirms the action was performed")
	public void on_response_confirms_the_action_was_performed(String keyValue, String Expectedvalue) {
	    assertEquals(getJsonPath(response, keyValue), Expectedvalue);
	}

	@Then("user cheks if this location has address {string}")
	public void user_cheks_if_this_location_has_address(String expected_address) {
		assertEquals(getJsonPath(response, "address"), expected_address);
	}
}
