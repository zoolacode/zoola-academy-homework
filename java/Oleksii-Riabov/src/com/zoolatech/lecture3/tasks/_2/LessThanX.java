package com.zoolatech.lecture3.tasks._2;

public class LessThanX implements Validator {

    private final int number;

    public LessThanX(int number) {
        this.number = number;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating that \"" + number + "\" is smaller than X");
        return true;
    }
}
