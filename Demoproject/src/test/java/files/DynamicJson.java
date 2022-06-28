package files;

import org.testng.annotations.*;
import io.restassured.*;
import io.restassured.path.json.*;
import static io.restassured.RestAssured.*;

public class DynamicJson {

	@Test(dataProvider ="BooksData")
	public void addBook(String isbn,String aisle)
	{
	RestAssured.baseURI ="http://216.10.245.166";
	
	//dynamically build Json payload with external data inputs
	
	String response = given().log().all().header("Content-Type","application/json").body(payload.Addbook(isbn,aisle))
	.when().post("/Library/Addbook.php")
	.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	JsonPath js = ReusableMethods.rawToJson(response);
	String id = js.get("ID");
	System.out.println(id);
	
	}
	
	//parameterizing tests to run with multiple datasets
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
	return	new Object[][] {{"jhkl","123"},{"dhfhg","43545"},{"lnjkj","7867"}};
	}
}
