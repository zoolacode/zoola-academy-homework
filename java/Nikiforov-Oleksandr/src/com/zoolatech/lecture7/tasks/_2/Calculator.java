package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Calculator {
    protected int value;

    public Calculator(int value) {
        this.value = value;
    }

    public void add(int valueToAdd) {
        value += valueToAdd;
    }

    public void subtract(int valueToSubtract) {
        value -= valueToSubtract;
    }

    public abstract <T> T getValue();
}
