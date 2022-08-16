package com.zoolatech.lecture7.tasks._2;

public class SyncCalculator implements Calculator {
    private int value;

    public synchronized void add(int addedValue) {
        value += addedValue;
        System.out.println("add: " + addedValue);
    }

    public synchronized void subtract(int subtracted) {
        value -= subtracted;
        System.out.println("subtract: " + subtracted);
    }

    public synchronized int getValue() {
        return value;
    }
}
