package com.zoolatech.lecture3.tasks._2;

public class NumberIsBiggerThanValueValidation implements Validator {
    private int birthDay;

    public NumberIsBiggerThanValueValidation(int birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean check = true;
        System.out.println("Checking that the number is bigger than 0: " + check);
        return check;    }
}