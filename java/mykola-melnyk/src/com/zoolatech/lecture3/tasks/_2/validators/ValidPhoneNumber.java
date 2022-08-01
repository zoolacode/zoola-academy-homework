package com.zoolatech.lecture3.tasks._2.validators;

import com.zoolatech.lecture3.tasks._2.UserAccount;

public class ValidPhoneNumber implements Validator {
    private String accountField;
    public ValidPhoneNumber(String accountField) {
        this.accountField = accountField;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating phone number %s \n",
                accountField);
        return true;
    }
}
