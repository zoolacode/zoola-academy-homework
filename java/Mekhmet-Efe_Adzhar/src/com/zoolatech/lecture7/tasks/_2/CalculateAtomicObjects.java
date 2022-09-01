package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class CalculateAtomicObjects extends Calculation{
    private final AtomicInteger value = new AtomicInteger(0);

    public CalculateAtomicObjects(int value) {
        getInt(value);
    }

    private int getInt(int value) {
        return value;
    }

    @Override
    public int currentValue() {
        return value.get();
    }

    @Override
    public int addition(int integer) {
        return value.addAndGet(getInt(integer));
    }

    @Override
    public int subtraction(int integer) {
        return value.get() - getInt(integer);
    }
}