package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCalculator implements Calculator {

    private AtomicInteger value = new AtomicInteger(0);

    @Override
    public void add(int addedValue) {
        System.out.println("Add: " + value.addAndGet(addedValue));
    }

    @Override
    public void subtract(int subtracted) {
        System.out.println("subtract: " + value.addAndGet(-subtracted));
    }

    @Override
    public int getValue() {
        return value.get();
    }
}
