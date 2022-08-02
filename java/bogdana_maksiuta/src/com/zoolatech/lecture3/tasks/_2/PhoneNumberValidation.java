package com.zoolatech.lecture3.tasks._2;

public class PhoneNumberValidation implements Validator {
    private String phoneNumber;

    public PhoneNumberValidation(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean check = true;
        System.out.println("Checking that the phone number is valid: " + check);
        return check;
    }
}
