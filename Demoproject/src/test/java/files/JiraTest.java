package files;
import static io.restassured.RestAssured.*;
import io.restassured.filter.session.*;
import java.io.File;

import io.restassured.RestAssured;
import  io.restassured.RestAssured.*;
import  io.restassured.path.json.*;
import org.testng.*;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//adding comment to a JIRA API issue , issue created by Postman
		
		RestAssured.baseURI="http://localhost:8080/";
		
		//here 10007 is the issue id
		
		//login scenario
		
		SessionFilter session = new SessionFilter();
		
		 String response = given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json").body("{ \"username\": \"muralidharpatnaik187\", \r\n"
				+ "\"password\": \"@#Alpha333\" }").filter(session).when().post("rest/auth/1/session")
		.then().log().all().extract().response().asString();
		 
		 //add comment
		 
		 String expectedMessage	 ="Hi How are you?";
	String addCommentResponse =	given().pathParam("key","10007").log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \""+expectedMessage+"\",\r\n"
				+ "    \"visibility\":{\r\n"
				+ "        \"type\":\"role\",\r\n"
				+ "        \"value\":\"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201)
	.extract().response().asString(); 
	
	JsonPath js = new JsonPath(addCommentResponse);
	
	String commentId = js.getString("id");
	System.out.println("=========");
	System.out.println(commentId);
		
		//add attachment
		
		given().log().all().header("X-Atlassian-Token","no-check").filter(session).pathParam("key","10007")
		.header("Content-Type","multipart/form-data")
		.multiPart("file", new File("Jira.txt"))
		.when().post("rest/api/2/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		
		//get issue
	 	
	     String issueDetails = given().filter(session).log().all().pathParam("key","10007")
	    		 .queryParam("fields","comment")
		.when().get("rest/api/2/issue/{key}")
		.then().log().all().extract().response().asString();
	     
	     System.out.println(issueDetails);
	     
	     JsonPath js1 = new JsonPath(issueDetails);
	   int commentsCount =  js1.getInt("fields.comment.comments.size()");
	   
	   //checking whether the last comment you added is present in the json response with the same body
	   
	   for(int i=0;i<commentsCount;i++)
	   {
		 String commentIdIssue = js1.get("fields.comment.comments["+i+"].id").toString(); 
		 if(commentIdIssue.equalsIgnoreCase(commentId))
		 {
			 String message	= js1.get("fields.comment.comments["+i+"].body").toString();
			 System.out.println(message);
			 Assert.assertEquals(message,expectedMessage);
			 
			 
		 }
	   }
	   
	   
	     
		
	

	}

}
