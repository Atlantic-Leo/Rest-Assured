package stepDefinitions; 

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition {
	
	//used tidy gherkin app

    @Given("^User is on net banking landing page$")
    public void user_is_on_net_banking_landing_page() throws Throwable {
    	//code to navigate to login url
    	System.out.println("Navigated to login url");
      
    }

    @When("^User login into application with \\\"([^\\\"]*)\\\" and passoword \\\"([^\\\"]*)\\\"$")
    public void user_login_into_application_with_username_and_passoword(String strArg1 , String strArg2) throws Throwable {
    	//code to login
    	System.out.println(strArg1);
    	System.out.println(strArg2);
    	System.out.println("Logged in successfully");
    
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
    	//home page validation
    	System.out.println("Validated homepage");
  
    }

    @And("^Cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are_something(String strArg1) throws Throwable {
        System.out.println(strArg1);
    }

}