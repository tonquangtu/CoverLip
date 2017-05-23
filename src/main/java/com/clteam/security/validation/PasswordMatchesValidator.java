package com.clteam.security.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;


/**
 * Created by Khanh Nguyen on 17/5/2017.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    private String field;
    private String verifyField;

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.verifyField = constraintAnnotation.verifyField();
    }

    /**
     * Showing validation errors with class level custom constraint annotatio
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
//        final AccountDto accountDto = (AccountDto) o;
//        boolean isMatches =  accountDto.getPassword().equals(accountDto.getPassword());
        Object fieldObj, verifyFieldObj;
        boolean isMatches = true;
        try {
            fieldObj = BeanUtils.getProperty(value, field);
            verifyFieldObj = BeanUtils.getProperty(value, verifyField);
            boolean firstCondition = fieldObj == null && verifyFieldObj == null;
            boolean secondCondition = fieldObj != null && fieldObj.equals(verifyFieldObj);
            isMatches =  firstCondition || secondCondition;
            if (!isMatches) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext
                        .buildConstraintViolationWithTemplate("Password is not match")
                        .addNode(verifyField).addConstraintViolation();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return isMatches;
    }
}
