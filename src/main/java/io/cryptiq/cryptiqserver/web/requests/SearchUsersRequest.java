package io.cryptiq.cryptiqserver.web.requests;

public class SearchUsersRequest {
	private String username;
	//private String firstName; TODO etc... advanced search
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
}
