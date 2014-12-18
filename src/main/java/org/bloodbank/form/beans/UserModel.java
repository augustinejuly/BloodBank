package org.bloodbank.form.beans;

import org.bson.types.ObjectId;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



/**
 * The User domain model
 *
 * @author	Alessandro Giannone
 * @version 1.0
 */

public class UserModel
{
	public static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
	private ObjectId id;	
	private String username;
	private String password;
	private String role;

	protected UserModel() {}

	public UserModel( String username, String password, String role )
	{
		this.username = username;
		//this.password = DigestUtils.sha1Hex( password );
		this.password = bCryptPasswordEncoder.encode(password);
		this.role = role;
	}

	public ObjectId getId() { return id; }
	public String getUsername() { return username; }
	public String getSHA1Password() { return password; }
	public String getRole() { return role; }

	@Override
	public int hashCode() {
		return username.length() * password.length() * 31;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof UserModel)) {
			return false;
		}
		UserModel that = (UserModel) obj;
		if(this.getUsername().equals(that.getUsername()) && this.getSHA1Password().equals(that.getSHA1Password())) {
			return true;
		}
		return false;
	}
	
}
