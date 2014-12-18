package org.bloodbank.jsr_303_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bloodbank.mongo.model.BloodRequestType;

@Constraint(validatedBy=BloodRequestTypeValidator.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface BloodRequestTypeRequired {

	String message() default "{bloodRequestType.required}";

	BloodRequestType[] bloodRequestType() default BloodRequestType.DONATE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
