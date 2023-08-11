package com.nissum.apiuser.utils;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nissum.apiuser.annotations.EmailFormat;

public class EmailFormatValidator implements ConstraintValidator<EmailFormat, String>{
	
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	@Override
    public void initialize(EmailFormat constraintAnnotation) {
    }
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email == null) {
            return false;
        }
        return Pattern.matches(EMAIL_PATTERN, email);
	}

}
