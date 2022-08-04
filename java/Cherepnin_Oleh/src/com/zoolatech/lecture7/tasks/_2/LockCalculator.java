package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.ReentrantLock;

public class LockCalculator implements Calculator {
    private ReentrantLock lock = new ReentrantLock();
    private int value;

    @Override
    public void add(int addedValue) {
        lock.lock();
        try {
            value += addedValue;
            System.out.println("add: " + addedValue);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void subtract(int subtracted) {
        lock.lock();
        try {
            value -= subtracted;
            System.out.println("subtract: " + subtracted);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getValue() {
        return value;
    }
}
