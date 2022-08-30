package com.zoolatech.lecture7.tasks._2;

public class CalculatorSynchronized implements Operations {

    private int value;

    public CalculatorSynchronized(int value) {
        this.value = value;
    }

    public synchronized int currentValue() {
        return value;
    }

    @Override
    public synchronized int addition(int number) {
        return this.value += number;
    }

    @Override
    public synchronized int subtraction(int number) {
        return this.value -= value;
    }

    public void synchronizedMethod() throws InterruptedException {
        Runnable taskAddition = () -> {
            for (int i = 0; i < 1000; i++) {
                addition(5);
            }
            System.out.println("Current Thread: " + Thread.currentThread().getName());
        };

        Runnable taskSubtraction = () -> {
            for (int i = 0; i < 1000; i++) {
                addition(5);
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
        System.out.println("\n" + currentValue() + " Current thread: " + Thread.currentThread().getName());

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