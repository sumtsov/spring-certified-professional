package com.dsumtsov.password.encoder.validation;

import com.dsumtsov.password.encoder.model.UserCredentials;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserCredentials.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCredentials registeringUser = (UserCredentials) target;

        if (!registeringUser.getPassword().equals(registeringUser.getRepeatedPassword())) {
            errors.rejectValue("password", null, "Password and repeated password needs to match.");
        }
    }
}
