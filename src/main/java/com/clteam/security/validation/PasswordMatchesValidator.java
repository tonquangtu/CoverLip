package com.clteam.security.validation;

import com.clteam.security.dto.AccountDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Khanh Nguyen on 17/5/2017.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        final AccountDto accountDto = (AccountDto) o;
        return accountDto.getPassword().equals(accountDto.getPassword());
    }
}
