package com.zoolatech.lecture3.tasks._2;

public class UserAccount {
    private int userID;
    private String firstName;
    private String lastName;
    private String country;
    private String userEmail;
    private String phoneNumber;
    private int birthDay;
    private int birthMonth;
    public UserAccount(int userID, String firstName, String lastName,
                       String country, String userEmail, String phoneNumber,
                       int birthDay, int birthMonth) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.userEmail = userEmail;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }
}
