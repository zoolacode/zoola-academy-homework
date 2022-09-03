package com.zoolatech.lecture3.tasks._2;

public record UserAccount(int userID, String firstName, String lastName, String country,
                          String userEmail, String phoneNumber,
                          int birthDay, int birthMonth) {}
