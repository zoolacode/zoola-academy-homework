package com.zoolatech.lecture3.tasks._2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmailValidator extends UserAccountFieldExtractor implements Validator {
    private String fieldName;

    public UserEmailValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        String fieldValue = getStringFieldValue(userAccount, fieldName);
        String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(fieldValue);

        if (matcher.matches()) {
            System.out.println("Valid email");
            return true;
        } else {
            System.out.println("Invalid email. Validating error");
            return false;
        }
    }
}
