package my.package.name

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class MyStepDefinitions {

    @Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {
        throw new PendingException();
    }

    @When("^user calls \"([^\"]*)\" with Post http request$")
    public void user_calls_something_with_post_http_request(String strArg1) throws Throwable {
        throw new PendingException();
    }

    @Then("^the API call is success with status code 200$")
    public void the_api_call_is_success_with_status_code_200() throws Throwable {
        throw new PendingException();
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {
        throw new PendingException();
    }

}