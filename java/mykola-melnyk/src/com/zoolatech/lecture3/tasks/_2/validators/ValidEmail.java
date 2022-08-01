package com.zoolatech.lecture3.tasks._2.validators;

import com.zoolatech.lecture3.tasks._2.UserAccount;

public class ValidEmail implements Validator {

    private final String accountField;
    public ValidEmail(String accountField) {
        this.accountField = accountField;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating email %s\n",
                accountField);
        return true;
    }
}
