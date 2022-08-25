package com.zoolatech.lecture7.tasks._2;

public class Calculator {
    private int value;

    public Calculator(int value) {
        this.value = value;
    }

    public int addition(int anotherValue) {
        return value += anotherValue;
    }

    public int subtraction(int anotherValue) {
        return value -= anotherValue;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
