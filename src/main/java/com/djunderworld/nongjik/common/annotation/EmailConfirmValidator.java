package com.djunderworld.nongjik.common.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.djunderworld.nongjik.entity.UserEntity;
import com.djunderworld.nongjik.repository.user.UserRepository;

public class EmailConfirmValidator implements ConstraintValidator<EmailConfirm, String> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(EmailConfirm emailConfirm) {

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		return validate(email);
	}

	public boolean validate(final String email) {

		UserEntity userEntity = userRepository.findByEmail(email);

		if (userEntity != null) {
			return false;
		} else {
			return true;
		}
	}
}
