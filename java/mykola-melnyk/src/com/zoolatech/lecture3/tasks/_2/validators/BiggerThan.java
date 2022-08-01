package com.zoolatech.lecture3.tasks._2.validators;

import com.zoolatech.lecture3.tasks._2.UserAccount;

public class BiggerThan implements Validator {
    private final int value;
    private final String accountField;
    public BiggerThan(String accountField, int value) {
        this.accountField = accountField;
        this.value = value;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating that %s is bigger than %d\n",
                            accountField, value);
        return true;
    }
}
