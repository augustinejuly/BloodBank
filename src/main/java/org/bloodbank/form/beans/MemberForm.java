package org.bloodbank.form.beans;

import javax.validation.Valid;

import org.bloodbank.mongo.model.MemberProfile;

public class MemberForm extends CommonForm{
	
	@Valid
	private MemberProfile memberProfile;
	
	public void setMemberProfile(MemberProfile memberProfile) {
		this.memberProfile = memberProfile;
	}

	public MemberProfile getMemberProfile() {
		return memberProfile;
	}
	
}
