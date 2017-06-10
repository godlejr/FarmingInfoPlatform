package com.djunderworld.nongjik.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)

public @interface Password {
	String message() default
	"영,숫자를 혼합한 6~20자를 입력하세요.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}