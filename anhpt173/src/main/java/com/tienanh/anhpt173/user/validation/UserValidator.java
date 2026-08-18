package com.tienanh.anhpt173.user.validation;

import org.springframework.util.StringUtils;

public class UserValidator {

    public boolean isValidEmail(String email){
        return StringUtils.hasText(email) && email.contains("@");
    }

    public boolean isValidPassword(String password){
        return StringUtils.hasText(password) && password.length() >= 8;
    }
}
