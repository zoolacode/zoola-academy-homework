package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicCalculator extends Calculator {
    public AtomicCalculator(int value) {
        super(value);
    }

    @Override
    public void add(int valueToAdd) {
        AtomicInteger atomicValue = new AtomicInteger(value);
        atomicValue.addAndGet(valueToAdd);
        value = atomicValue.get();
        System.out.println("Add - " + valueToAdd);
    }

    @Override
    public void subtract(int valueToSubtract) {
        AtomicInteger atomicValue = new AtomicInteger(value);
        atomicValue.addAndGet(-valueToSubtract);
        value = atomicValue.get();
        System.out.println("Subtract - " + valueToSubtract);
    }
}
