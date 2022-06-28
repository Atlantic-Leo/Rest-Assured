import org.testng.annotations.*;
import org.testng.Assert.*;

import io.restassured.path.json.JsonPath;


public class SumValidation {
	
	@Test
	public void sumOfCourses()
	{
		int sum=0;
		JsonPath js = new JsonPath(files.payload.CoursePrice());

		int count = js.getInt("courses.size()");
		
		for(int i=0;i<count;i++)
	    {
	      int price = js.getInt("courses["+i+"].price");
	      int copies = js.getInt("courses["+i+"].copies");
	      
	      int amount = price*copies;
	      System.out.println(amount);
	      sum = sum + amount;
	    
	    }
		
		System.out.println(sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		org.testng.Assert.assertEquals(sum,purchaseAmount);
		

}
}