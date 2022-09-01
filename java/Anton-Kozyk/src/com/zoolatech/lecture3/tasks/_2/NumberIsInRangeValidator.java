package com.zoolatech.lecture3.tasks._2;

public class NumberIsInRangeValidator extends Validator {
    public NumberIsInRangeValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is in the range between X and Y...");
        return true;
    }

}
