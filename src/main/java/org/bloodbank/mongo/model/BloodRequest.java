package org.bloodbank.mongo.model;

import java.util.Date;

import org.bloodbank.jsr_303_validators.BloodGroupRequired;
import org.bloodbank.jsr_303_validators.BloodRequestTypeRequired;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection="bloodRequest")
public class BloodRequest {
	
	@Id
	private Long bloodRequestId;
	
	@BloodGroupRequired(message="{bloodgroup.required}")
	private BloodGroup bloodGroup;
	
	@BloodRequestTypeRequired(message="{bloodRequestType.required}")
	private BloodRequestType bloodRequestType;
	
	@DBRef(lazy=false)
	private CommonUserProfile requestPostedBy;
	
	@DBRef(lazy=true)
	private CommonUserProfile requestMetBy;
	
	@DateTimeFormat(pattern="DD/MM/YYYY")
	private Date postedTime;
	
	@Range(min=1, message="{units.required}")
	private int numberOfUnits;
	
	@NotEmpty(message="{bloodRequest.description.required}")
	private String description;

	public Long getBloodRequestId() {
		return bloodRequestId;
	}

	public void setBloodRequestId(Long bloodRequestId) {
		this.bloodRequestId = bloodRequestId;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public BloodRequestType getBloodRequestType() {
		return bloodRequestType;
	}

	public void setBloodRequestType(BloodRequestType bloodRequestType) {
		this.bloodRequestType = bloodRequestType;
	}

	public CommonUserProfile getRequestPostedBy() {
		return requestPostedBy;
	}

	public void setRequestPostedBy(CommonUserProfile requestPostedBy) {
		this.requestPostedBy = requestPostedBy;
	}

	public CommonUserProfile getRequestMetBy() {
		return requestMetBy;
	}

	public void setRequestMetBy(CommonUserProfile requestMetBy) {
		this.requestMetBy = requestMetBy;
	}

	public Date getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(Date postedTime) {
		this.postedTime = postedTime;
	}

	public int getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
