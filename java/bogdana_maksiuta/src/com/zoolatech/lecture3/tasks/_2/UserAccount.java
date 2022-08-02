package com.zoolatech.lecture3.tasks._2;

import java.util.Objects;

public class UserAccount {
    private int userId;
    private String firstName;
    private String lastName;
    private String country;
    private String userEmail;
    private String phoneNumber;
    private int birthDay;
    private int birthMonth;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public UserAccount(int userId, String firstName, String lastName, String country,
                       String userEmail, String phoneNumber, int birthDay, int birthMonth) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return userId == that.userId && birthDay == that.birthDay && birthMonth == that.birthMonth && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(country, that.country) && Objects.equals(userEmail, that.userEmail) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, country, userEmail, phoneNumber, birthDay, birthMonth);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDay=" + birthDay +
                ", birthMonth=" + birthMonth +
                '}';
    }
}
