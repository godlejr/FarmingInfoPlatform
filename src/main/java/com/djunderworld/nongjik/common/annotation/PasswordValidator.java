package com.djunderworld.nongjik.common.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	private String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[0-9]).{6,20})";

	@Override
	public void initialize(Password password) {

	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext arg1) {
		return validate(password);
	}

	public boolean validate(final String password) {
		if (password != null) {
			Matcher matcher;
			Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);

			return matcher.matches();
		} else {
			return false;
		}
	}

}
