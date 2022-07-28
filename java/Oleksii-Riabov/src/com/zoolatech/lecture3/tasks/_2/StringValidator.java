package com.zoolatech.lecture3.tasks._2;

public class StringValidator extends AccountValidator {
    String fieldName;

    public StringValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        switch (fieldName) {
            case "firstName" -> {
                System.out.println("Validating that firstName field: " + userAccount.firstName() + " is not empty");
                return true;
            }
            case "lastName" -> {
                System.out.println("Validating that lastName field: " + userAccount.lastName() + " is not empty");
                return true;
            }
            case "country" -> {
                System.out.println("Validating that country field: " + userAccount.country() + " is not empty");
                return true;
            }
            case "userEmail" -> {
                System.out.println("Validating that userEmail field: " + userAccount.userEmail() + " uses valid email");
                return true;
            }
            case "phoneNumber" -> {
                System.out.println("Validating that phoneNumber field: " + userAccount.phoneNumber() + " uses valid phone number");
                return true;
            }
            default -> { return false; }
        }
    }
}
