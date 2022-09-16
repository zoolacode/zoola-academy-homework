package com.zoolatech.lecture7.tasks._2;


public class SynchronizedCalculator {

    private int value;

    public SynchronizedCalculator(int value) {
        this.value = value;
    }

    public synchronized void add(int value2) {
            this.value += value2;
    }

    public synchronized void subtract(int value2) {
        this.value -= value2;
    }

    public synchronized int getValue() {
            return this.value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
