package com.nissum.apiuser.utils;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nissum.apiuser.annotations.PasswordFormat;

public class PasswordValidator implements ConstraintValidator<PasswordFormat, String>{
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z]).{5,}$";
    
    @Override
    public void initialize(PasswordFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
}
