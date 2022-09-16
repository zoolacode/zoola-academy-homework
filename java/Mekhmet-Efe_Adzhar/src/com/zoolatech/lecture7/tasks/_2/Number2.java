package com.zoolatech.lecture7.tasks._2;

/*
Define a class that represents a calculator.
The class should provide methods that accept another value and perform addition
or subtraction operation on a value stored in a calculator instance.
The class should also provide a method to get a current value.
The class should work only with integer values.
Assume all operation results fit into the range of values for a current value type.
Assume all operations will be executed from multiple threads, so make sure the class is thread-safe.
Implement three versions of the class:
1. using explicit locks
2. using synchronized
3. using atomic objects
*/

public class Number2 {
    public static void main(String[] args) throws InterruptedException {

        CalculationExplicitLocks calculationExplicitLocks = new CalculationExplicitLocks(5);
        CalculatorSynchronized calculatorSynchronized = new CalculatorSynchronized(5);
        CalculateAtomicObjects calculateAtomicObjects = new CalculateAtomicObjects(5);

        Runnable runnable = () -> {
            try {
                operations(calculationExplicitLocks);
                operations(calculatorSynchronized);
                operations(calculateAtomicObjects);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        System.out.println("Task is done");
    }

    public static void operations(Operations operations) throws InterruptedException {
        Runnable taskAddition = () -> {
            for (int i = 0; i < 1000; i++) {
                operations.addition(5);
            }
            System.out.println("Current Thread: " + Thread.currentThread().getName());
        };

        Runnable taskSubtraction = () -> {
            for (int i = 0; i < 1000; i++) {
                operations.subtraction(5);
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
        System.out.println("\n" + operations.currentValue() + " Current thread: " + Thread.currentThread().getName());

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(taskSubtraction);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println("\n" + operations.currentValue() + " Current thread: " + Thread.currentThread().getName());
    }
}