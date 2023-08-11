package com.nissum.apiuser.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.nissum.apiuser.utils.PasswordValidator;





@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordFormat {
	String message() default "Contraseña con formato invalido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
