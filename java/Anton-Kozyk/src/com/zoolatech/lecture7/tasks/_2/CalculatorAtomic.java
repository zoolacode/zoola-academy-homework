package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class CalculatorAtomic {
    AtomicInteger atomicInteger;

    public CalculatorAtomic(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    public void addition(int anotherValue) {
        atomicInteger.addAndGet(anotherValue);
    }

    public void subtraction(int anotherValue) {
        atomicInteger.addAndGet(-anotherValue);
    }

    public AtomicInteger getValue() {
        return atomicInteger;
    }
}
