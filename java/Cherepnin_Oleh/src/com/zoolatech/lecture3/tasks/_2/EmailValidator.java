package com.zoolatech.lecture3.tasks._2;

public class EmailValidator extends AbstractSmallerValidator {

    public EmailValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        if (ValidationPattern.EMAIL.getPattern().matcher(user.getEmail()).matches()) {
            return true;
        }
        System.out.println("Email is invalid");
        return false;
    }
}
