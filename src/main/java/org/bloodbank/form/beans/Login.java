package org.bloodbank.form.beans;

import org.hibernate.validator.constraints.NotEmpty;


public class Login {
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	private String role;

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return username.length() * password.length() * 31;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Login)) {
			return false;
		}
		Login that = (Login) obj;
		if(this.getUsername().equals(that.getUsername()) && this.getPassword().equals(that.getPassword())) {
			return true;
		}
		return false;
	}
}
