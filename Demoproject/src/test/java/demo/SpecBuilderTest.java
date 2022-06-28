package demo;
import static io.restassured.RestAssured.*;
import io.restassured.filter.session.*;
import io.restassured.response.*;
import io.restassured.builder.*;
import io.restassured.specification.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


import io.restassured.RestAssured;
import  io.restassured.RestAssured.*;
import  io.restassured.path.json.*;
import org.testng.*;

public class SpecBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
        RequestSpecification req = new  RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
		.setContentType(io.restassured.http.ContentType.JSON).build();
	
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
	 	p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setName("Frontline house"); 
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		
		//simply giving a java object to the body method instead of giving a json payload
		//serialization
	RequestSpecification res =	given().spec(req).body(p);
	
	ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(io.restassured.http.ContentType.JSON).build();
	
	Response response   = res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
	
	String responseString = response.asString();
	System.out.println(responseString);
	 
	
		
		
		

	}

}
