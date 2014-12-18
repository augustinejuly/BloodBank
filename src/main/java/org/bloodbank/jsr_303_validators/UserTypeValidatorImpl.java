package org.bloodbank.jsr_303_validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.bloodbank.mongo.model.UserType;

public class UserTypeValidatorImpl implements ConstraintValidator<UserTypeRequired, UserType>{
	
	private List<String> userTypes = new ArrayList<String>();

	@Override
	public void initialize(UserTypeRequired constraintAnnotation) {
		for (UserType userType : UserType.values()) {
			userTypes.add(userType.name());
		}
	}

	@Override
	public boolean isValid(UserType userType, ConstraintValidatorContext context) {
		if(userType == null) {
			return false;
		}
		
		return userTypes.contains(userType.name())? true : false;
	}

}
