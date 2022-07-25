package com.zoolatech.lecture3.tasks._2;

public class UserIdValidator implements ValidatorInterface {
    private int minUserId = 0;
    private int UserId;

    public UserIdValidator(int UserId) {
        this.UserId = UserId;
    }

    @Override
    public boolean isValid() {
        if (UserId > minUserId) {
            System.out.println("Validating UserId is more than " + minUserId);
            return true;
        } else {
            System.out.println("Validator UserId is less than " + minUserId + ". Validation error");
            return false;
        }
    }
}
