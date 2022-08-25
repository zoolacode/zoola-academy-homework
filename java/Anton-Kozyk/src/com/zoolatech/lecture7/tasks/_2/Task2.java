package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Define a class that represents a calculator. The class should provide methods
 * that accept another value and perform addition or subtraction operation on a
 * value stored in a calculator instance. The class should also provide a method
 * to get a current value. The class should work only with integer values.
 * Assume all operation results fit into the range of values for a current value
 * type. Assume all operations will be executed from multiple threads, so make
 * sure the class is thread-safe. Implement three versions of the class:
 * <p>
 * using explicit locks
 * using synchronized
 * using atomic objects
 */

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator(0);
        CalculatorAtomic calculatorAtomic = new CalculatorAtomic(0);
        CalculatorExplicitLock calculatorExplicitLock = new CalculatorExplicitLock(0);
        CalculatorSynchronized calculatorSynchronized = new CalculatorSynchronized(0);

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                calculator.addition(10);
                calculatorSynchronized.addition(10);
                calculatorExplicitLock.addition(10);
                calculatorAtomic.addition(10);
            }
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Simple calculator: " + calculator.getValue() +
                "\natomics calculator: " + calculatorAtomic.getValue() +
                "\ncalculator using explicit lock: " + calculatorExplicitLock.getValue() +
                "\ncalculator using synchronized: " + calculatorSynchronized.getValue());
    }
}
