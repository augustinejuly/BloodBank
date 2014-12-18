package org.bloodbank.form.beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CommonForm {
	
	@NotEmpty(message="{username.required}")
	@Size(min=6, max=15, message="{username.length}")
	protected String username;
	
	@NotEmpty(message="{password.required}") 
	@Size(min=6,max=15,message="{password.length}")
	protected String password;
	
	@NotEmpty(message="{confirmPassword.required}")
	protected String confirmPassword;
	
	protected String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
