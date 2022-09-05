package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCalculator {

    private AtomicInteger value;

    public AtomicCalculator(int value) {
          this.value = new AtomicInteger(value);
    }

    public void add(int value2) {
        this.value.addAndGet(value2);
    }

    public void subtract(int value2) {
        this.value.accumulateAndGet(value2, Math::subtractExact);
    }

    public int getValue() {
       return this.value.get();
    }

    public void setValue(int value) {
        this.value.set(value);
    }
}
