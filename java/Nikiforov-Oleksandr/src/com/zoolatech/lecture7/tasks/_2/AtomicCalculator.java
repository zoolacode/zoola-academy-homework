package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCalculator extends Calculator {
    private final AtomicInteger atomicValue;

    public AtomicCalculator(int value) {
        super(value);
        this.atomicValue = new AtomicInteger(value);
    }

    @Override
    public void add(int valueToAdd) {
        atomicValue.addAndGet(valueToAdd);
        System.out.println("Add - " + valueToAdd);
    }

    @Override
    public void subtract(int valueToSubtract) {
        atomicValue.addAndGet(-valueToSubtract);
        System.out.println("Subtract - " + valueToSubtract);
    }

    @Override
    public AtomicInteger getValue() {
        return atomicValue;
    }

}
