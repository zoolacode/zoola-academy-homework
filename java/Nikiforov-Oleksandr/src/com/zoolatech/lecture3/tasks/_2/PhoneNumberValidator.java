package com.zoolatech.lecture3.tasks._2;

public class PhoneNumberValidator implements ValidatorInterface {
    private String phoneNumber;

    public PhoneNumberValidator(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid() {
        if (phoneNumber.isEmpty()) {
            System.out.println("Field phone number is empty. Validation error");
            return false;
        } else {
            System.out.println("Field phone number is not empty");
            return true;
        }
    }
}
