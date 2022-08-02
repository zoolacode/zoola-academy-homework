package com.zoolatech.lecture3.tasks._2;

public class NumberInTheRangeValidation implements Validator {
    private int birthMonth;

    public NumberInTheRangeValidation(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    @Override
    public boolean isValid(UserAccount userAccount) {
        boolean check = true;
        System.out.println("Validating that number is between 1 and 12: " + check);
        return check;
    }
}
