package com.zoolatech.lecture3.tasks._2;

public class NumberValidator extends AbstractSmallerValidator {
    public NumberValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(User user) {
        System.out.println("validating that " + fieldName + " is valid");
        if (ValidationPattern.NUMBER.getPattern().matcher(user.getPhoneNumber()).matches()) {
            return true;
        }
        printMassage();
        return false;
    }
}
