package com.zoolatech.lecture3.tasks._2;

public class ValidPhoneNumber implements Validator {

    public final String phoneNumber;

    public ValidPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating that \"" + phoneNumber + "\" is correct");
        return true;
    }
}
