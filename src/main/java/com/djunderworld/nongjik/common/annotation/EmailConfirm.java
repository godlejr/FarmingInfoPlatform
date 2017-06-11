package com.djunderworld.nongjik.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailConfirmValidator.class)

public @interface EmailConfirm {
	String message() default
	"사용중인 이메일입니다.";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
