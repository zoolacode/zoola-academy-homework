package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Calculator {
    Lock lock = new ReentrantLock();
    private int value;
    AtomicInteger getValue = new AtomicInteger(5);

    public Calculator(int value) {
        this.value = value;
    }

    public int currentValue() {
        return value;
    }

    public AtomicInteger currentValueForAtomicInteger() {
        return getValue;
    }

    public int additioinExplicitLock(int value) {
        lock.lock();
        try {
            return this.value += value;
        } finally {
            lock.unlock();
        }
    }

    public int subtractionExplicitLock(int value) {
        lock.lock();
        try {
            return this.value -= value;
        } finally {
            lock.unlock();
        }
    }

    public synchronized int additioinSynchronized(int value) {
        return this.value += value;
    }

    public int subtractionSynchronized(int value) {
        synchronized (this) {
            return this.value -= value;
        }
    }

    public int atomicAddition(int value) {
        return getValue.addAndGet(value);
    }

    public int atomicSubstraction(int value) {
        return getValue.get() - value;
    }
}