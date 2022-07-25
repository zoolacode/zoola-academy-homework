package com.zoolatech.lecture3.tasks._2;

public class UserEmailValidator implements ValidatorInterface{
    private String userEmail;

    public UserEmailValidator(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean isValid() {
        if (userEmail.isEmpty()) {
            System.out.println("Field user email is empty. Validation error");
            return false;
        } else {
            System.out.println("Field user email is not empty");
            return true;
        }
    }
}
