package com.zoolatech.lecture3.tasks._2;

import java.util.regex.Pattern;

public class UserEmailValidator extends AccountValidator {

    public UserEmailValidator(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean patternMatches(String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(userEmail)
                .matches();
    }

    @Override
    public boolean isValid() {
        String regexPattern = "^(.+)@(\\S+)$";
        return patternMatches(regexPattern);
    }

}



