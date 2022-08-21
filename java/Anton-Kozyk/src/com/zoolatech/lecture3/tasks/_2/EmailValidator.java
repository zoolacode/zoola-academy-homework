package com.zoolatech.lecture3.tasks._2;

public class EmailValidator extends Validator {
    public EmailValidator(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean isValid(UserAccount account) {
        System.out.println("Validating that <" + fieldName + "> is valid...");
        return true;
    }
}
