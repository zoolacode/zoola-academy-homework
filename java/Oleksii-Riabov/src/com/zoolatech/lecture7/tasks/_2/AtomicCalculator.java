package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCalculator {

    private AtomicInteger value;

    public AtomicCalculator(int value) {
          this.value = new AtomicInteger(value);
    }

    public synchronized void add(int value2) {
        this.value.accumulateAndGet(value2, Integer::sum);
    }

    public synchronized void subtract(int value2) {
        this.value.accumulateAndGet(value2, Math::subtractExact);
    }

    public synchronized int getValue() {
       return this.value.get();
    }

    public synchronized void setValue(int value) {
        this.value.set(value);
    }
}
