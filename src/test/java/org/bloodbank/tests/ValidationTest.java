package org.bloodbank.tests;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.bloodbank.mongo.model.MemberProfile;
import org.junit.Test;

public class ValidationTest {
	
	@Test
	public void testValidationForFailure() throws Exception {

		MemberProfile memberProfile = new MemberProfile();
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<MemberProfile>> violations = validator.validate(memberProfile);
		//assertEquals(violations.size(), 5);
		assertTrue(violations.size() > 0);
	}

}
