package io.cryptiq.cryptiqserver.web.requests;

public class SendMessageRequest {
	private String content;
	private int sentTo;
	private int sentFrom;
	
	/* GETTERS AND SETTERS */
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	
	public int getSentTo() { return sentTo; }
	public void setSentTo(int sentTo) { this.sentTo = sentTo; }
	
	public int getSentFrom() { return sentFrom; }
	public void setSentFrom(int sentFrom) { this.sentFrom = sentFrom; }
}
