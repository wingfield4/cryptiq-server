package io.cryptiq.cryptiqserver.web.requests;

public class SetDeviceTokenRequest {
	private int userId;
	private String deviceToken;
	
	/* GETTERS AND SETTERS */
	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	
	public String getDeviceToken() { return deviceToken; }
	public void setDeviceToken(String deviceToken) { this.deviceToken = deviceToken; } 
}
