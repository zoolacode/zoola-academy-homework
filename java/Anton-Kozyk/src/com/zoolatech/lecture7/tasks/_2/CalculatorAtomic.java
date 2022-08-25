package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class CalculatorAtomic {
    private AtomicInteger atomicInteger;

    public CalculatorAtomic(int value) {
        this.atomicInteger = new AtomicInteger(value);
    }

    public void addition(int anotherValue) {
        atomicInteger.addAndGet(anotherValue);
    }

    public void subtraction(int anotherValue) {
        atomicInteger.addAndGet(-anotherValue);
    }

    public int getValue() {
        return atomicInteger.intValue();
    }
}
