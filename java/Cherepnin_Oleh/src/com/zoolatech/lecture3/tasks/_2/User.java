package com.zoolatech.lecture3.tasks._2;

public class User {
    private static long idCounter = 1;
    private long id;
    private String firstName;
    private String lastName;
    private String country;
    private String email;
    private String phoneNumber;
    private int birthDay;
    private int birthMonth;

    public User(String firstName, String lastName, String country, String email,
                String phoneNumber, int birthDay, int birthMonth) {
        this.id = idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        idCounter++;
    }

    public long getId() {
        return id;
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

    public String getEmail() {
        return email;
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
