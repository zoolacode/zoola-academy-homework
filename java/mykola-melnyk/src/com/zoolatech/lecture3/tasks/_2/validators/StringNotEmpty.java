package com.zoolatech.lecture3.tasks._2.validators;

import com.zoolatech.lecture3.tasks._2.UserAccount;

public class StringNotEmpty implements Validator {
    private String accountField;
    public StringNotEmpty(String accountField) {
        this.accountField = accountField;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating that string %s is not empty \n",
                accountField);
        return false;
    }
}
