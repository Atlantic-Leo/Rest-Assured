package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


import static io.restassured.RestAssured.*;

import java.util.*;

import io.restassured.path.json.*;
import pojo.Api;
import pojo.GetCourse;
import io.restassured.parsing.*;
import org.testng.*;

@RunWith(Cucumber.class)
public class stepDefinition {
	
	GetCourse gc;
	String  accessTokenResponse;
	String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
	String accessToken;
	String code;
	

	    @Given("^User is on login page$")
	    public void user_is_on_login_page() throws Throwable, InterruptedException {
	    
			
	
			
//	driver.get("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow");
		
	String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjarHUnQWxAbRCKJf-mzZ_A0XGTqPUjlEolOIXLKOZOwKJAmc__XGY4zLHO6ogrng&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
			
		//split the string to extract code
		String partialcode	= url.split("code=")[1];
		 code = partialcode.split("&scope")[0];
		System.out.println(code);
		
		//say to rest assured to not to tamper with the "code" if it has special characters
			
			//API call to get the "Access token"
			
		 
	       
	    }

	    @When("^User logs in$")
	    public void user_logs_in() throws Throwable, InterruptedException {
	    	
	    	accessTokenResponse = given().urlEncodingEnabled(false).queryParams("code",code)
	    			.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	    			.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
	    			.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
	    			.queryParams("grant_type","authorization_code")
	    			.when().log().all()
	    			.post("https://www.googleapis.com/oauth2/v4/token").asString();
	    		
	    		JsonPath js = new JsonPath(accessTokenResponse);
	    	 accessToken = js.getString("access_token");
	    	
	    	System.out.println("Success");
	
	    }

	    @Then("^Courses are displayed$")
	    public void courses_are_displayed() throws Throwable, InterruptedException {
	    	
	    	//to print the reponse as a string
	    	//String response = given().queryParam("access_token",accessToken)
	    	//.when()
	    	//.get("https://rahulshettyacademy.com/getCourse.php").asString();
	    			
	    			
	    			//final API call
	    	
	    	 gc = given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
	    				.when()
	    				.get("https://rahulshettyacademy.com/getCourse.php").as(pojo.GetCourse.class);
	    				
	    				//gc is the object of the GetCourse class
//	    				System.out.println(response);
	    				
	    				System.out.println(gc.getLinkedIn());
	    				System.out.println(gc.getInstructor());
	    				
	    				//navigating to a particular mini json and extracting details using pojo classes
	    				System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	    				
	    				List<Api> apiCourses =gc.getCourses().getApi();
	    				for(int i=0;i<apiCourses.size();i++)
	    				{
	    					if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
	    							{
	    						      System.out.println(apiCourses.get(i).getPrice());  
	    							}
	    					
	    				}
	    				
	    				//getting course titles of WebAutomation
	    				//comparing the course titles with expected course titles
	    				//expected titles array is courseTitles
	    				//use array list when the array is dynamic
	    				//convert the string array of expected course titles to array list so it will become easy to compare
	    				ArrayList<String> a = new ArrayList<String>();
	    				List<pojo.WebAutomation> w = gc.getCourses().getWebAutomation();
	    				for(int j=0;j<w.size();j++)
	    				{
	    					a.add(w.get(j).getCourseTitle());
	    				}
	    				
	    				List<String> expectedList = Arrays.asList(courseTitles);
	    				
	    				Assert.assertTrue(a.equals(expectedList));
	    	System.out.println("Done");

	    }

	}


