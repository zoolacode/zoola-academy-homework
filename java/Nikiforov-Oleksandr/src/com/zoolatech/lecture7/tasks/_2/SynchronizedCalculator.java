package com.zoolatech.lecture7.tasks._2;

import java.sql.SQLOutput;

public class SynchronizedCalculator extends Calculator {

    public SynchronizedCalculator(int value) {
        super(value);
    }

    @Override
    public void add(int valueToAdd) {
        synchronized (this) {
            super.add(valueToAdd);
            System.out.println("Add - " + valueToAdd);
        }
    }

    @Override
    public void subtract(int valueToSubtract) {
        synchronized (this) {
            super.subtract(valueToSubtract);
            System.out.println("Subtract - " + valueToSubtract);
        }
    }

    @Override
    public Object getValue() {
        return value;
    }
}
