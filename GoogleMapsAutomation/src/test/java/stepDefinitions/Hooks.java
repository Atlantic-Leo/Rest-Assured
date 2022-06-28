package stepDefinitions;

import java.io.*;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		StepDefinition m = new StepDefinition();
		if(StepDefinition.place_id==null)
		{
			m.addplace_Payload_with("John","Spanish","Spain");
			m.user_calls_with_http_request("AddPlaceAPI","POST");
			m.verify_created_placeId_to_using("John","GetPlaceAPI");

		}
	}

}
