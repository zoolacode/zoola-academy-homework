package com.zoolatech.lecture7.tasks._2;

public class CalculatorSynchronized extends Calculator {
    CalculatorSynchronized(int value) {
        super(value);
    }

    @Override
    public synchronized int addition(int anotherValue) {
        return super.addition(anotherValue);
    }

    @Override
    public synchronized int subtraction(int anotherValue) {
        return super.subtraction(anotherValue);
    }
}
