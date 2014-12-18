package org.bloodbank.mongo.model;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userProfiles")
public class CommonUserProfile {
	
	/*@Id
	@Indexed(unique=true)
	@NotEmpty(message="{username.required}")
	@Size(min=4, max=15, message="{username.length}")
	private String username;
	
	@NotEmpty(message="{password.required}") 
	@Size(min=4,max=15,message="{password.length}")
	private String password;
	
	
	@Transient
	@NotEmpty(message="{confirmPassword.required}")
	private String confirmPassword;
	*/
	
	@Id
	@Indexed(unique=true)
	private String username;
	
	protected UserType userType;
	
	@Valid
	protected ContactDetail contactDetail;

	/*public String getUsername() {
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
*/
	
	public CommonUserProfile() {
		this.contactDetail = new ContactDetail();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserType getUserType() {
		return userType;
	}

	public ContactDetail getContactDetail() {
		return contactDetail;
	}

	public void setContactDetail(ContactDetail contactDetail) {
		this.contactDetail = contactDetail;
	}

	/*public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}*/

}
