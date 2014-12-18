package org.bloodbank.mongo.model;

import javax.validation.constraints.NotNull;

import org.bloodbank.jsr_303_validators.BloodGroupRequired;
import org.bloodbank.jsr_303_validators.GenderRequired;
import org.bloodbank.mongo.model.GenderType.GENDER;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.context.annotation.Scope;

@Scope("session")
public class MemberProfile extends CommonUserProfile{
	
	@NotEmpty(message="{member.firstname}")
	private String memberFirstName;
	
	@NotEmpty(message="{member.lastname}")
	private String memberLastName;
	
	@NotNull(message="{age.required}")
	@Range(min=18,max=55,message= "{age.range}")
	private int age;
	
	@GenderRequired(message= "{gender.required}")
	private GENDER gender;
	
	@BloodGroupRequired(message="{bloodgroup.required}")
	private BloodGroup bloodGroup;
	
	public MemberProfile() {
		this.userType = UserType.MEMBER;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

}
