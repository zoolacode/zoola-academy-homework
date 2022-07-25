package com.zoolatech.lecture3.tasks._2;

public class FirstNameValidator implements ValidatorInterface {
    private String firstName;

    public FirstNameValidator(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean isValid() {
        if (firstName.isEmpty()) {
            System.out.println("Field firstname is empty. Validation error");
            return false;
        } else {
            System.out.println("Field firstname is not empty");
            return true;
        }
    }
}
