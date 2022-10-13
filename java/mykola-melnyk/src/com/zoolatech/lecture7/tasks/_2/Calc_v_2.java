package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calc_v_2 implements Calc {
    private int storedValue;
    private Lock calcLock = new ReentrantLock();
    public Calc_v_2(int value) {
        storedValue = value;
    }
    public int getStoredValue() {
        calcLock.lock();
        try {
            return storedValue;
        } finally {
            calcLock.unlock();
        }
    }
    public int add(int operand) {
        calcLock.lock();
        try {
           return storedValue += operand;
        }
        finally {
            calcLock.unlock();
        }
    }
    public int subtract(int operand) {
        calcLock.lock();
        try {
           return storedValue -= operand;
        }
        finally {
            calcLock.unlock();
        }
    }
}
