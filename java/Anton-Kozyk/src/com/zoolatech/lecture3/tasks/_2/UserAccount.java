package com.zoolatech.lecture3.tasks._2;

public class UserAccount {
    int userId;
    String firstName;
    String lastName;
    String country;
    String userEmail;
    String phoneNumber;
    int birthDay;
    int birthMonth;

    UserAccount(int userId, String firstName, String lastName, String country, String userEmail,
                String phoneNumber, int birthDay, int birthMonth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
    }
}
