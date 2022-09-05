package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ExplicitLockCalculator {

    private int value;

    private Lock lock = new ReentrantLock();

    public ExplicitLockCalculator(int value) {
        this.value = value;
    }

    public void add(int value2) {
        lock.lock();

        try {
            this.value += value2;
        } finally {
            lock.unlock();
        }
    }

    public void subtract(int value2) {
        lock.lock();

        try {
            this.value -= value2;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        lock.lock();

        try {
            return this.value;
        } finally {
            lock.unlock();
        }
    }

    public void setValue(int value) {
        lock.lock();

        try {
            this.value = value;
        } finally {
            lock.unlock();
        }
    }
}
