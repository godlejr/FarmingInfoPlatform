package com.djunderworld.nongjik.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BusinessNumberValidator.class)

public @interface BusinessNumber {
	String message() default
	"올바른 사업자등록번호를 입력하세요.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
