package org.bloodbank.jsr_303_validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bloodbank.mongo.model.GenderType.GENDER;

public class GenderValidatorImpl implements ConstraintValidator<GenderRequired,GENDER>{
	
	private List<String> genders = new ArrayList<String>();

	@Override
	public void initialize(GenderRequired genderNotNull) {
		
		for (GENDER gender : GENDER.values()) {
			genders.add(gender.name());
		}
	}

	@Override
	public boolean isValid(GENDER gender, ConstraintValidatorContext context) {
		
		if(gender == null) {
			return false;
		}
		
		return genders.contains(gender.name())? true : false;
	}

}
