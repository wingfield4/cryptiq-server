package io.cryptiq.cryptiqserver.web.responses;

import java.util.Date;

public class SendMessageResponse {
	private Date sentAt;
	
	/* GETTERS */
	public Date getSentAt() { return sentAt; }
	public SendMessageResponse setSentAt(Date sentAt) { this.sentAt = sentAt; return this; }
}
