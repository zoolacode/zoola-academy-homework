package com.zoolatech.lecture3.tasks._2;

public class NotEmpty implements Validator {

    private final String string;

    public NotEmpty(String string) {
        this.string = string;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating that \"" + string + "\" is not empty");
        return true;
    }
}
