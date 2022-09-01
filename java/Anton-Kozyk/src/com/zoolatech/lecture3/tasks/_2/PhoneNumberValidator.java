package com.zoolatech.lecture3.tasks._2;

public class PhoneNumberValidator extends Validator {
    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is valid...");
        return true;
    }

    public PhoneNumberValidator(String fieldName) {
        super(fieldName);
    }
}
