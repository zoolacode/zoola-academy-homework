package com.zoolatech.lecture3.tasks._2;

public class ValidEmail implements Validator {

    private final String email;

    public ValidEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating that \"" + email + "\" is correct");
        return true;
    }
}
