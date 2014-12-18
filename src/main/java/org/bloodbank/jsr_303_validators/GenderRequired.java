package org.bloodbank.jsr_303_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bloodbank.mongo.model.GenderType.GENDER;

@Constraint(validatedBy=GenderValidatorImpl.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface GenderRequired {

	String message() default "{gender.required}";

	GENDER[] genders() default GENDER.MALE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
