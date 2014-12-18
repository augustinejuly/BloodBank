package org.bloodbank.jsr_303_validators;


import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bloodbank.mongo.model.BloodRequestType;

public class BloodRequestTypeValidator implements ConstraintValidator<BloodRequestTypeRequired, BloodRequestType> {
	
	List<String> bloodRequestsList = new ArrayList<String>();

	@Override
	public void initialize(BloodRequestTypeRequired constraintAnnotation) {
		for (BloodRequestType requestType : BloodRequestType.values()) {
			bloodRequestsList.add(requestType.name());
		}
	}

	@Override
	public boolean isValid(BloodRequestType bloodRequestType,
			ConstraintValidatorContext context) {
		if(bloodRequestType == null) {
			return false;
		}
		
		return bloodRequestsList.contains(bloodRequestType.name())? true : false;
	}

}
