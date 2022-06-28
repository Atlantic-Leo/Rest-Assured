package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import resources.utils;
import resources.*;

public class StepDefinition extends utils{
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	Testdatabuild data = new Testdatabuild();
	static String place_id;
	

@Given("AddPlace Payload with {string}  {string} {string}")
public void addplace_Payload_with(String name, String language, String address) throws IOException {
	
		 
		 res=given().spec(requestSpecification())
		.body(data.addPlacePayLoad(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String apiname, String httpmethod) {
		
		APIResources resourceAPI = APIResources.valueOf(apiname);
		System.out.println(resourceAPI.getResource());
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(io.restassured.http.ContentType.JSON).build();
		
		if(httpmethod.equalsIgnoreCase("POST"))
			response = res.when().post(resourceAPI.getResource());
		else if(httpmethod.equalsIgnoreCase("GET"))
			response=res.when().get(resourceAPI.getResource());
			

	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		
		assertEquals(response.getStatusCode(),200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expected) {
		assertEquals(getJsonPathValue(response,key),expected);

	}
	
	@Then("verify created placeId to {string} using {string}")
	public void verify_created_placeId_to_using(String expected, String apiname) throws IOException {
		
		place_id=getJsonPathValue(response,"place_id");
		res=given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(apiname,"GET");
		String responseValue=getJsonPathValue(response,"name");
		assertEquals(responseValue,expected);
	   
	}


	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
		
	
		res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));

	}
	


}
