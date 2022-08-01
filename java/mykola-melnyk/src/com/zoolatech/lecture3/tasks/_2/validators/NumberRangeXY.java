package com.zoolatech.lecture3.tasks._2.validators;

import com.zoolatech.lecture3.tasks._2.UserAccount;

public class NumberRangeXY implements Validator {
    private final String accountField;
    private final int x;
    private final int y;
    public NumberRangeXY(String accountField, int x, int y) {
        this.accountField = accountField;
        this.x = x;
        this.y = y;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating that %s is in the range between %d and %d \n",
                accountField, x, y);
        return true;
    }
}
