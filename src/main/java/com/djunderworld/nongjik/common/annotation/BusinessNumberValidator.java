package com.djunderworld.nongjik.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BusinessNumberValidator implements ConstraintValidator<BusinessNumber, String> {

	@Override
	public void initialize(BusinessNumber businessNumber) {

	}

	@Override
	public boolean isValid(String businessNumber, ConstraintValidatorContext arg1) {
		return validate(businessNumber);
	}

	public boolean validate(final String businessNumber) {
		businessNumber.trim();

		if (businessNumber != null && businessNumber.length() == 10) {

			for (int i = 0; i < businessNumber.length(); i++) {
				if (businessNumber.charAt(i) < '0' || businessNumber.charAt(i) > '9') {
					return false;
				}
			}

			int sum = 0;
			String checkNo = "137137135";
			for (int i = 0; i < checkNo.length(); i++) {
				sum += (businessNumber.charAt(i) - '0') * (checkNo.charAt(i) - '0');
			}
			sum += ((businessNumber.charAt(8) - '0') * 5) / 10;
			sum %= 10;
			sum = 10 - sum;

			if (sum == businessNumber.charAt(9)-'0') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
}
