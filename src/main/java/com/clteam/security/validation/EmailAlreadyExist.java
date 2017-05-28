package com.clteam.security.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Khanh Nguyen on 17/5/2017.
 */
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EmailAlreadyExistValidator.class)
@Documented
public @interface EmailAlreadyExist {

    String message() default "{EmailAlreadyExist.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}