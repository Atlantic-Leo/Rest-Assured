package parsing;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import io.restassured.path.json.*;

import pojo.*;
import io.restassured.parsing.*;
import org.testng.*;

public class Test {
	
	public static void main(String[] args) {
		
		//when json response starts with an array
		
	       response[] responses =    given()
				.when().get("https://jsonplaceholder.typicode.com/posts/1/comments").as(response[].class);
	             
	
              System.out.println(responses[1].getId());

				
	}
	
	

}
