package com.djunderworld.nongjik.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.djunderworld.nongjik.common.flag.LogFlag;
import com.djunderworld.nongjik.entity.User;
import com.djunderworld.nongjik.service.user.UserService;

public class EmailConfirmValidator implements ConstraintValidator<EmailConfirm, String> {

	@Autowired
	private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(EmailConfirmValidator.class);

	
	@Override
	public void initialize(EmailConfirm emailConfirm) {

	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {

		return validate(email);

	}

	public boolean validate(final String email) {
		User user = null;
		try {
			user = userService.getUserByEmail(email);

		} catch (NullPointerException e) {
			log(e);
		}

		if (user != null) {
			return false;
		} else {
			return true;
		}

	}
	
	 private static void log(Throwable throwable) {
	        StackTraceElement[] ste = throwable.getStackTrace();
	        String className = ste[0].getClassName();
	        String methodName = ste[0].getMethodName();
	        int lineNumber = ste[0].getLineNumber();
	        String fileName = ste[0].getFileName();

	        if (LogFlag.printFlag) {
	            if (logger.isInfoEnabled()) {
	                logger.error("Exception: " + throwable.getMessage());
	                logger.error(className + "." + methodName + " " + fileName + " " + lineNumber + " " + "line");
	            }
	        }
	    }

}
