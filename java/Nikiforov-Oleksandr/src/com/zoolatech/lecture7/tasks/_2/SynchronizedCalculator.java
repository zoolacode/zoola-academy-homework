package com.zoolatech.lecture7.tasks._2;

import java.sql.SQLOutput;

public class SynchronizedCalculator extends Calculator {

    public SynchronizedCalculator(int value) {
        super(value);
    }

    @Override
    public synchronized void add(int valueToAdd) {
        super.add(valueToAdd);
    }

    @Override
    public synchronized void subtract(int valueToSubtract) {
        super.subtract(valueToSubtract);
    }
}
