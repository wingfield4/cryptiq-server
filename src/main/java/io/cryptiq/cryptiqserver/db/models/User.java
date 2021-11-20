package io.cryptiq.cryptiqserver.db.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true)
	private String username;
	@Column(unique=true, length = 500)
	private String publicKey;
	@Column(length = 500)
	private String deviceToken;
	

	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String middleName;
	@Column(length = 100)
	private String lastName;
	@Column(length = 100)
	private String email;
	@Column(length = 100)
	private String phone;
	
	/* HELPERS */
	@JsonIgnore
	public String getFormattedName()
	{
		List<String> tokens = new ArrayList<>();
		
		if(firstName != null || lastName != null || middleName != null) 
		{
			if(firstName != null)
				tokens.add(firstName);
			
			if(middleName != null)
				tokens.add(middleName);
			
			if(lastName != null)
				tokens.add(lastName);
		}
		else 
		{
			tokens.add(username);
		}
		
		
		return String.join(" ", tokens);
	}
	
	/* GETTERS AND SETTERS */
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	
	public String getPublicKey() { return publicKey; }
	public void setPublicKey(String publicKey) { this.publicKey = publicKey; }

	@JsonIgnore
	public String getDeviceToken() { return deviceToken; }
	public void setDeviceToken(String deviceToken) { this.deviceToken = deviceToken; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	public String getMiddleName() { return middleName; }
	public void setMiddleName(String middleName) { this.middleName = middleName; }
	
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
}
