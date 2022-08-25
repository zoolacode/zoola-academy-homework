package com.zoolatech.lecture3.tasks._2;

public class NumberIsLessValidator extends Validator {
    public NumberIsLessValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is less than a X...");
        return true;
    }
}
