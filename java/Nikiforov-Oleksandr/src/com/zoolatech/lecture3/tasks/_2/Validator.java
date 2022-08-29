package com.zoolatech.lecture3.tasks._2;

public interface Validator {
    boolean isValid(UserAccount userAccount);

    default String getStringFieldValue(UserAccount userAccount, String fieldName) {
        switch (fieldName) {
            case ("firstName") -> {
                return userAccount.getFirstName();
            }
            case ("lastName") -> {
                return userAccount.getLastName();
            }
            case ("phonenumber") -> {
                return userAccount.getPhonenumber();
            }
            case ("country") -> {
                return userAccount.getCountry();
            }
            case ("userEmail") -> {
                return userAccount.getUserEmail();
            }
        }

        return "";
    }

    default int getIntFieldValue(UserAccount userAccount, String fieldName) {
        switch (fieldName) {
            case ("userId") -> {
                return userAccount.getUserId();
            }
            case ("birthDay") -> {
                return userAccount.getBirthDay();
            }
            case ("birthMonth") -> {
                return userAccount.getBirthMonth();
            }
        }

        return 0;
    }

}
