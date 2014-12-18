package org.bloodbank.jsr_303_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bloodbank.mongo.model.UserType;

@Constraint(validatedBy=UserTypeValidatorImpl.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserTypeRequired {
	
	String message() default "{usertype.required}";

	UserType[] userType() default UserType.MEMBER;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
