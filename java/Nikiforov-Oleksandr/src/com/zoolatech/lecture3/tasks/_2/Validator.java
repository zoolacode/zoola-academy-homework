package com.zoolatech.lecture3.tasks._2;

public interface Validator {
    boolean isValid(UserAccount userAccount);

//    default String getStringFieldValue(UserAccount userAccount, String fieldName) {
//        return switch (fieldName) {
//            case ("firstName") -> userAccount.getFirstName();
//            case ("lastName") -> userAccount.getLastName();
//            case ("phonenumber") -> userAccount.getPhonenumber();
//            case ("country") -> userAccount.getCountry();
//            case ("userEmail") -> userAccount.getUserEmail();
//            default -> "";
//        };
//    }
//
//    default int getIntFieldValue(UserAccount userAccount, String fieldName) {
//        return switch (fieldName) {
//            case ("userId") -> userAccount.getUserId();
//            case ("birthDay") -> userAccount.getBirthDay();
//            case ("birthMonth") -> userAccount.getBirthMonth();
//            default -> 0;
//        };
//    }

}
