package com.zoolatech.lecture7.tasks._2;

public class CalculatorSynchronized extends Calculation {

    private int value;

    public CalculatorSynchronized(int value) {
        this.value = value;
    }

    public synchronized int currentValue() {
        return value;
    }

    @Override
    public synchronized int addition(int number) {
        return this.value += number;
    }

    @Override
    public synchronized int subtraction(int number) {
        return this.value -= value;
    }
}