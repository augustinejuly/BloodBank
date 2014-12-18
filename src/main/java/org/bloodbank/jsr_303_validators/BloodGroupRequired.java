package org.bloodbank.jsr_303_validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.bloodbank.mongo.model.BloodGroup;

@Constraint(validatedBy=BloodGroupValidatorImpl.class)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface BloodGroupRequired {
	
	String message() default "{bloodgroup.required}";

	BloodGroup[] bloodGroups() default BloodGroup.A1_NEGATIVE;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
