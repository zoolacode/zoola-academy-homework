package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

public class CalculateAtomicObjects implements Operations {
    private final AtomicInteger getValue;
    private int value;

    public CalculateAtomicObjects(int value, AtomicInteger getValue) {
        this.value = value;
        this.getValue = getValue;
    }

    public AtomicInteger currentValueForAtomicInteger() {
        return getValue;
    }

    @Override
    public int addition(int integer) {
        value = integer;
        return getValue.addAndGet(value);
    }

    @Override
    public int subtraction(int integer) {
        value = integer;
        return getValue.get() - value;
    }

    public void atomicOperation() throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                addition(5);
            }
            System.out.println("Current thread: " + Thread.currentThread().getName() + currentValueForAtomicInteger());
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                subtraction(5);
            }
            System.out.println("Current thread: " + Thread.currentThread().getName() + currentValueForAtomicInteger());
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println("\n" + currentValueForAtomicInteger() + " Current thread: " + Thread.currentThread().getName());
    }
}