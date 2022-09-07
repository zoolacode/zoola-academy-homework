package com.zoolatech.lecture3.tasks._2;

public class MoreThanX implements Validator {

    private final int number;

    public MoreThanX(int number) {
        this.number = number;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating that serId field: " + number + " is bigger than X");
        return true;
    }
}
