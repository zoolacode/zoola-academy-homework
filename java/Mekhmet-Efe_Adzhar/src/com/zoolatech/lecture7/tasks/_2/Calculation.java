package com.zoolatech.lecture7.tasks._2;

public abstract class Calculation implements Operations  {
    private int value;
    public int currentValue() {
        return value;
    }

    @Override
    public int addition(int number) {
        return value + number;
    }

    @Override
    public int subtraction(int number) {
        return value - number;
    }
}