package com.zoolatech.lecture3.tasks._2.validators;

import com.zoolatech.lecture3.tasks._2.UserAccount;

public class LessThan implements Validator {
    private final int value;
    private final String accountField;
    public LessThan(String accountField, int value) {
        this.accountField = accountField;
        this.value = value;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating that %s is less than %d\n",
                            accountField, value);
        return true;
    }
}
