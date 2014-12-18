package org.bloodbank.mongo.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ContactDetail {
	
	private static final String ADDRESS_NOT_AVAILABLE = "No address available";
	
	private String address;	
	
	private String city;
	
	private String state;
	
	private String postalCode;
	
	@NotEmpty(message="{phone.required}")
	private String phones;
	
	@NotEmpty(message="{email.required}")
	@Email(message="{invalid.email}")
	private String email;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullAddress() {
		String empty = "";
		StringBuffer sb = new StringBuffer();
		sb.append((this.address==null || this.address.isEmpty()) ? empty : this.address.concat(","));
		sb.append((this.city==null || this.city.isEmpty()) ? empty : this.city.concat(","));
		sb.append((this.state==null || this.city.isEmpty()) ? empty : this.state.concat(","));
		sb.append((this.postalCode==null) ? empty : this.postalCode);
		return sb.length() == 0 ? ADDRESS_NOT_AVAILABLE : sb.toString();
	}
	
}
