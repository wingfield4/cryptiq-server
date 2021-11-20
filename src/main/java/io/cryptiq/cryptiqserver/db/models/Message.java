package io.cryptiq.cryptiqserver.db.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 1000)
	private String encryptedContent;
	@Column(length = 1000)
	private String signature;
	private Date sentAt;
	private Integer sentFrom;
	private Integer sentTo;
	private Date receivedAt;
	private Date readAt;
	
	/* GETTERS AND SETTERS */
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getEncryptedContent() { return encryptedContent; }
	public void setEncryptedContent(String encryptedContent) { this.encryptedContent = encryptedContent; }
	
	public String getSignature() { return signature; }
	public void setSignature(String signature) { this.signature = signature; }
	
	public Date getSentAt() { return sentAt; }
	public void setSentAt(Date sentAt) { this.sentAt = sentAt; }
	
	public Integer getSentFrom() { return sentFrom; }
	public void setSentFrom(Integer sentFrom) { this.sentFrom = sentFrom; }
	
	public Integer getSentTo() { return sentTo; }
	public void setSentTo(Integer sentTo) { this.sentTo = sentTo; }
	
	public Date getReceivedAt() { return receivedAt; }
	public void setReceivedAt(Date receivedAt) { this.receivedAt = receivedAt; }
	
	public Date getReadAt() { return readAt; }
	public void setReadAt(Date readAt) { this.readAt = readAt; }
}
