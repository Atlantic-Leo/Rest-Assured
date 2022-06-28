package resources;

import java.util.*;
import pojo.*;

public class Testdatabuild {
	
	public AddPlace addPlacePayLoad(String name,String language, String address)
	{
		AddPlace p = new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setName(name);
		p.setLanguage(language);
		p.setPhone_number("123456789");
		p.setWebsite("https://rahulshettyacademy.com");
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("park");
		
		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
		
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

}
