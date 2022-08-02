package com.zoolatech.lecture3.tasks._2;

public class StringIsNotEmptyValidation implements Validator {
    private String firstName;
    private String lastName;
    private String country;
    private String userEmail;
    private String phoneNumber;

    public StringIsNotEmptyValidation(String firstName, String lastName, String country, String userEmail, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean check = true;
        System.out.println("Checking that the string is not empty: " + check);
        return check;
    }
}

