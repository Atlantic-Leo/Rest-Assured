import io.restassured.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.*;
import org.testng.*;

import java.io.IOException;
import java.nio.file.*;

public class Basics {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//AddPlace API
		
		//given , when , then
		//given - all input details
		//when -  HTTP method and source name
		//then - assertions
		
		//getting json payload from external file
		//convert file to string format , json->byte->String
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	    //getting json from external file
		.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\DELL\\Desktop\\Macy's\\Json parsing\\addPlace.json")))).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		
		System.out.println(placeId);
		
		//UpdatePlace API
		String newAddress = "70 winter walk, USA";
		
		given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GetPlace API
		
		String getPlaceResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id",placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
	    JsonPath js1 = files.ReusableMethods.rawToJson(getPlaceResponse);
		
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress,newAddress);
		
		//Add place -> update place with put place API -> Get place to check if new place is present in the response
		
		
		
		

	}

}
