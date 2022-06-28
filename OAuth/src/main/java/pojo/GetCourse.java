package pojo;

public class GetCourse {
	
	private	String services;
	private	String expertise;
	private Courses Courses; //here Courses is a mini json
	private	String instructor;
	private	String linkedIn;
	
	//press Alt Shift S to generate getters and setters
	//refer oAuthTest.java for Json response and jsoneditoronline.org
	
	//the "Courses" variable is again having a Json , this is called nested json
	//json is nested and it is wrapped up in an array
	
	private String url;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public Courses getCourses() { //change the method return type to Courses
		return Courses;
	}
	public void setCourses(Courses courses) { //change the return type to Courses
		Courses = courses;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	
	

}
