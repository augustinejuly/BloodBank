package org.bloodbank.form.beans;

import javax.validation.Valid;

import org.bloodbank.mongo.model.ProviderProfile;

public class ProviderForm extends CommonForm{
	
	@Valid
	private ProviderProfile providerProfile;
	
	public ProviderProfile getProviderProfile() {
		return providerProfile;
	}

	public void setProviderProfile(ProviderProfile providerProfile) {
		this.providerProfile = providerProfile;
	}
	
}
