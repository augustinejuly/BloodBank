package org.bloodbank.mongo.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;

@Scope("session")
public class ProviderProfile extends CommonUserProfile{
	
	@NotEmpty(message="{provider.name}")
	private String providerName;
	
	public ProviderProfile() {
		this.userType = UserType.PROVIDER;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

}
