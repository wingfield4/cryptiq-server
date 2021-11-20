package io.cryptiq.cryptiqserver.web.requests;

import java.util.Date;

public class NewMessagesRequest {
	private int userId;
	private Date lastReceived;
	
	/* GETTERS */
	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	
	public Date getLastReceived() { return lastReceived; }
	public void setLastReceived(Date lastReceived) { this.lastReceived = lastReceived; }
}
