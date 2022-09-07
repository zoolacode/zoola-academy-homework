package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class Calc_v_3 implements Calc {
    private AtomicInteger storedValue;
    public Calc_v_3(int value) {
        storedValue = new AtomicInteger(value);
    }
    public int getStoredValue() {
       return storedValue.get();
    }
    public int add(int operand) {
        return storedValue.addAndGet(operand);
    }
    public int subtract(int operand) {
        return storedValue.addAndGet(-operand);
    }
}
