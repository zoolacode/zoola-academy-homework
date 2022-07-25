package com.zoolatech.lecture3.tasks._2;

public class LastNameValidator implements ValidatorInterface {
    private String lastName;

    public LastNameValidator(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean isValid() {
        if (lastName.isEmpty()) {
            System.out.println("Field lastname is empty. Validation error");
            return false;
        } else {
            System.out.println("Field lastname is not empty");
            return true;
        }
    }
}
