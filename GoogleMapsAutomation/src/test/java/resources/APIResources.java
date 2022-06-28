package resources;

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String apiname;
	
	 APIResources(String apiname) {
		
		this.apiname=apiname;
		
	}
	
	public String getResource()
	{
		return apiname;
	}
	
	

}
