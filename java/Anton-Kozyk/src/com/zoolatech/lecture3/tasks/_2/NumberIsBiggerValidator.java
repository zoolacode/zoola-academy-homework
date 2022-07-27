package com.zoolatech.lecture3.tasks._2;

public class NumberIsBiggerValidator extends Validator {
    public NumberIsBiggerValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is bigger than X...");
        return true;
    }
}
