package com.zemoso.springboot.cruddemo.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NoDuplicatesValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NoDuplicates {
	
	//define default error message
	public String message() default "Enter new book";
	
	//define default groups
	public Class<?>[] groups() default {};
	
	//define default payloads
	public Class<? extends Payload>[] payload() default {};
}
