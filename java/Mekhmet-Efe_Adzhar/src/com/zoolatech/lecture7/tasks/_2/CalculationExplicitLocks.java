package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CalculationExplicitLocks implements Operations{
    private final Lock lock = new ReentrantLock();
    private int value;

    public CalculationExplicitLocks(int value) {
        this.value = value;
    }

    @Override
    public int currentValue() {
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int addition(int integer) {
        lock.lock();
        try {
            return this.value += integer;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int subtraction(int integer) {
        lock.lock();
        try {
            return this.value -= integer;
        } finally {
            lock.unlock();
        }
    }
}