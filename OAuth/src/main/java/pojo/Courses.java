package pojo;

import java.util.List;

public class Courses {
	
	//creating another pojo class for nested json
	
	
	private List<WebAutomation> webAutomation; //webAutomation again has three mini jsons in it
	//declare as List to include sqaure brackets
	private List<Api> api;
	private List<Mobile> mobile;
	
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<Api> getApi() {
		return api;
	}
	public void setApi(List<Api> api) {
		this.api = api;
	}
	public List<Mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}
	

}
