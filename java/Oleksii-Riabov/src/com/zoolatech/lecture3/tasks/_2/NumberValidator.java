package com.zoolatech.lecture3.tasks._2;

public class NumberValidator extends AccountValidator {
    String fieldName;

    public NumberValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        switch (fieldName) {
            case "userId" -> {
                System.out.println("Validating that serId field: " + userAccount.userId() + " is bigger than 0");
                return true;
            }
            case "birthDay" -> {
                System.out.println("Validating that birthDay field: " + userAccount.birthDay() + " is in the range between 0 and 32");
                return true;
            }
            case "birthMonth" -> {
                System.out.println("Validating that birthMonth field: " + userAccount.birthMonth() + " is in the range between 0 and 13");
                return true;
            }
            default -> { return false; }
        }
    }
}