package com.zoolatech.lecture7.tasks._2;

public class SyncCalculator implements Calculator {
    private volatile int value;

    public void add(int addedValue) {
        synchronized (this) {
            value += addedValue;
            System.out.println("add: " + addedValue);
        }
    }

    public void subtract(int subtracted) {
        synchronized (this) {
            value -= subtracted;
            System.out.println("subtract: " + subtracted);
        }
    }

    public int getValue() {
        synchronized (this) {
            return value;
        }
    }
}
