package com.zoolatech.lecture3.tasks._2;

public class UserAccount{
    public int userId;
    public String firstName;
    public String lastName;
    public String country;
    public String userEmail;
    public String phonenumber;
    public int birthDay;
    public int birthMonth;

    public UserAccount(int userId, String firstName, String lastName, String country, String userEmail, String phonenumber, int birthDay, int birthMonth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.userEmail = userEmail;
        this.phonenumber = phonenumber;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
    }
}
