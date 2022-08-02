package com.zoolatech.lecture3.tasks._2;

public class EmailValidation implements Validator {
    private String userEmail;

    public EmailValidation(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean check = true;
        System.out.println("Checking that the email is valid: " + check);
        return check;
    }
}