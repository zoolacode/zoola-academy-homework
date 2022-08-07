package com.zoolatech.lecture7.tasks._2;

class ThreadOperations {

    public static void explicitLocks() throws InterruptedException {
        Calculator calculator = new Calculator(5);

        Runnable taskAddition = () -> {
            for (int i = 0; i < 1000; i++) {
                calculator.additioinExplicitLock(3);
            }
            System.out.println("Current Thread: " + Thread.currentThread().getName());
        };

        Runnable taskSubstraction = () -> {
            for (int i = 0; i < 1000; i++) {
                calculator.subtractionExplicitLock(3);
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
        System.out.println("\n" + calculator.currentValue() + " Current thread: " + Thread.currentThread().getName() + "\n");
        Thread.sleep(1000);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taskSubstraction);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println("\n" + calculator.currentValue() + " Current thread: " + Thread.currentThread().getName());
    }

    public static void synchronizedMethod() throws InterruptedException {
        Calculator calculator = new Calculator(5);
        Runnable taskAddition = () -> {
            for (int i = 0; i < 1000; i++) {
                calculator.additioinSynchronized(3);
            }
            System.out.println("Current Thread: " + Thread.currentThread().getName());
        };

        Runnable taskSubstraction = () -> {
            for (int i = 0; i < 1000; i++) {
                calculator.subtractionSynchronized(3);
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
        System.out.println("\n" + calculator.currentValue() + " Current thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taskSubstraction);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println("\n" + calculator.currentValue() + " Current thread: " + Thread.currentThread().getName());
    }

    public static void atomicOperation() throws InterruptedException {
        Calculator calculator = new Calculator(5);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                calculator.atomicAddition(3);
            }
            System.out.println("Current thread: " + Thread.currentThread().getName() + calculator.currentValueForAtomicInteger());
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                calculator.atomicSubstraction(3);
            }
            System.out.println("Current thread: " + Thread.currentThread().getName() + calculator.currentValueForAtomicInteger());
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
        System.out.println("\n" + calculator.currentValueForAtomicInteger() + " Current thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}