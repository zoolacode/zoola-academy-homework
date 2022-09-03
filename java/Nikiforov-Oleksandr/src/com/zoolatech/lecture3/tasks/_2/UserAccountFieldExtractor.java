package com.zoolatech.lecture3.tasks._2;

public class UserAccountFieldExtractor {
    protected String getStringFieldValue(UserAccount userAccount, String fieldName) {
        return switch (fieldName) {
            case ("firstName") -> userAccount.getFirstName();
            case ("lastName") -> userAccount.getLastName();
            case ("phonenumber") -> userAccount.getPhonenumber();
            case ("country") -> userAccount.getCountry();
            case ("userEmail") -> userAccount.getUserEmail();
            default -> "";
        };
    }

    protected int getIntFieldValue(UserAccount userAccount, String fieldName) {
        return switch (fieldName) {
            case ("userId") -> userAccount.getUserId();
            case ("birthDay") -> userAccount.getBirthDay();
            case ("birthMonth") -> userAccount.getBirthMonth();
            default -> 0;
        };
    }
}
