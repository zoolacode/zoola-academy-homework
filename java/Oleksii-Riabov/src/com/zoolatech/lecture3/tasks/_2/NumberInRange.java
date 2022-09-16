package com.zoolatech.lecture3.tasks._2;

public class NumberInRange implements Validator {

    private final int number;

    public NumberInRange(int number) {
        this.number = number;
    }

    @Override
    public boolean isValid() {
        System.out.println("Validating that \"" +number+ "\" is in the range between X and Y");
        return true;
    }
}
