package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CalculationExplicitLocks implements Operations {
    private final Lock lock = new ReentrantLock();
    private int value;

    public CalculationExplicitLocks(int value) {
        this.value = value;
    }

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

    public void explicitLocks() throws InterruptedException {

        Runnable taskAddition = () -> {
            for (int i = 0; i < 1000; i++) {
               addition(5);
            }
            System.out.println("Current Thread: " + Thread.currentThread().getName());
        };

        Runnable taskSubtraction = () -> {
            for (int i = 0; i < 1000; i++) {
              subtraction(5);
            }
            System.out.println("Current Thread: " + Thread.currentThread().getName());
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taskAddition);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println("\n" + currentValue() + " Current thread: " + Thread.currentThread().getName() + "\n");

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taskSubtraction);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println("\n" + currentValue() + " Current thread: " + Thread.currentThread().getName());
    }
}