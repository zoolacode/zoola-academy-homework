package com.zoolatech.lecture3.tasks._2;

public class StringIsNotEmptyValidator extends Validator {
    public StringIsNotEmptyValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is not empty...");
        return true;
    }
}
