package com.clteam.security.validation;

import com.clteam.security.repository.AccountSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Khanh Nguyen on 18/5/2017.
 */
@Service
public class EmailAlreadyExistValidator implements ConstraintValidator<EmailAlreadyExist, String> {

    @Autowired
    private AccountSecurityRepository accountSecurityRepository;

    @Override
    public void initialize(EmailAlreadyExist emailAlreadyExist) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (accountSecurityRepository.findByEmail(s) == null) {
            return true;
        }
        return false;
    }
}
