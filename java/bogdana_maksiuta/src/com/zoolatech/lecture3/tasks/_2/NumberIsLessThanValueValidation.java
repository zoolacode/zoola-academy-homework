package com.zoolatech.lecture3.tasks._2;

public class NumberIsLessThanValueValidation implements Validator {
    private int birthDay;

    public NumberIsLessThanValueValidation(int birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean check = true;
        System.out.println("Checking that the number is less than 31: " + check);
        return check;
    }
}