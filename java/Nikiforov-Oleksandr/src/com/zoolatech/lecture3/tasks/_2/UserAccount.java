package com.zoolatech.lecture3.tasks._2;

public class UserAccount {
    private int userId;
    private String firstName;
    private String lastName;
    private String country;
    private String userEmail;
    private String phonenumber;
    private int birthDay;
    private int birthMonth;

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

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }
}
