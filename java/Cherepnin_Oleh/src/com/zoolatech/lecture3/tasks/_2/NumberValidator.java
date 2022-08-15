package com.zoolatech.lecture3.tasks._2;

public class NumberValidator extends AbstractSmallerValidator {
    public NumberValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        if (ValidationPattern.NUMBER.getPattern().matcher(user.getPhoneNumber()).matches()) {
            return true;
        }
        System.out.println("Phone number is invalid");
        return false;
    }
}
