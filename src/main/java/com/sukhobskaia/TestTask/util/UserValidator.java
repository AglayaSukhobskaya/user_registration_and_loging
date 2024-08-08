package com.sukhobskaia.TestTask.util;

import com.sukhobskaia.TestTask.model.User;
import com.sukhobskaia.TestTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserService peopleService;

    @Autowired
    public UserValidator(UserService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User person = (User) target;

        if (peopleService.getByUsername(person.getUsername()) != null) {
            errors.rejectValue("username", "","Person with this username already exists!");
        }
    }
}
