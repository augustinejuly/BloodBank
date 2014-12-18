package org.bloodbank.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userCredential")
public class UserCredential {
	
	@Id	
	@Indexed(unique=true)
	private final String username;
	
	private final String password;
	
	private final String role;
	
	public UserCredential(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
		//this.role = (role == null) ? "user" : role;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}
	
}
