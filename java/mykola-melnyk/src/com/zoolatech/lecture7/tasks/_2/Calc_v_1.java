package com.zoolatech.lecture7.tasks._2;

public class Calc_v_1 {
    private volatile int storedValue;
    public Calc_v_1(int value) {
        storedValue = value;
    }
    public double getStoredValue() {
        return storedValue;
    }
    public synchronized int addition(int operand) {
       return storedValue += operand;
    }
    public synchronized int subtract(int operand) {
       return storedValue -= operand;
    }


}
