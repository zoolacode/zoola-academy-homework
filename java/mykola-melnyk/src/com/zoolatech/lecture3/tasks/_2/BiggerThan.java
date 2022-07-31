package com.zoolatech.lecture3.tasks._2;

public class BiggerThan {
    private int value;
    private String accountField;
    public BiggerThan(int value, String accountField) {
        this.value = value;
        this.accountField = accountField;
    }

    public boolean isValid(UserAccount account) {
        System.out.printf("Validating that %s is bigger than %d", accountField, value);
        return true;
    }
}
