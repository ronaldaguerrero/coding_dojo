package com.codingdojo.javabelt.validator;

import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.codingdojo.javabelt.models.User;


@Component
public class UserValidator implements Validator{
    // 1
    @Override
    public boolean supports(Class<?> clazz) { //  Specifies that a instance of the User Domain Model can be validated with this custom validator
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) { // Creating our custom validation. We can add errors via .rejectValue(String, String).
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match"); // the first argument is the member variable of our Domain model that we are validating. The second argument is a code for us to use to set an error message.
        }         
    }
}
