package org.bloodbank.jsr_303_validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bloodbank.mongo.model.BloodGroup;

public class BloodGroupValidatorImpl implements ConstraintValidator<BloodGroupRequired, BloodGroup> {
	
	private List<String> bloodGroups = new ArrayList<String>();

	@Override
	public void initialize(BloodGroupRequired constraintAnnotation) {
		for (BloodGroup bloodGroup : BloodGroup.values()) {
			bloodGroups.add(bloodGroup.name());
		}
		
	}

	@Override
	public boolean isValid(BloodGroup bloodGroup, ConstraintValidatorContext context) {
		//if(bloodGroup == null || bloodGroup.equals(BloodGroup.SELECT)) {
		if(bloodGroup == null) {
			return false;
		}
		
		return bloodGroups.contains(bloodGroup.name())? true : false;
	}

}
