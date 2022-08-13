package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CalculatorExplicitLock extends Calculator {
    public CalculatorExplicitLock(int value) {
        super(value);
    }

    private Lock lock = new ReentrantLock();

    @Override
    public int addition(int anotherValue) {
        lock.lock();
        try {
            return super.addition(anotherValue);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int subtraction(int anotherValue) {
        lock.lock();
        try {
            return super.subtraction(anotherValue);
        } finally {
            lock.unlock();
        }
    }
}
