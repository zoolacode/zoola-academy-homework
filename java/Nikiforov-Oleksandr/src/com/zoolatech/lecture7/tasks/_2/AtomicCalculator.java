package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicCalculator {
    AtomicInteger value;

    public AtomicCalculator(int value) {
        this.value = new AtomicInteger(value);
    }

    public void add(int valueToAdd) {
        value.addAndGet(valueToAdd);
        System.out.println("Add - " + valueToAdd);
    }


    public void subtract(int valueToSubtract) {
        value.addAndGet(-valueToSubtract);
        System.out.println("Subtract - " + valueToSubtract);
    }

    public int getValue() {
        return value.get();
    }
}
