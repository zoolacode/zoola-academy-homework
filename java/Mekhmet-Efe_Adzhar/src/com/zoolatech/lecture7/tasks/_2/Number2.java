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

import java.util.concurrent.atomic.AtomicInteger;

public class Number2 {
    public static void main(String[] args) throws InterruptedException {

        CalculationExplicitLocks calculationExplicitLocks = new CalculationExplicitLocks(5);
        CalculatorSynchronized calculatorSynchronized = new CalculatorSynchronized(5);

        AtomicInteger atomicInteger = new AtomicInteger(0);

        CalculateAtomicObjects calculateAtomicObjects = new CalculateAtomicObjects(5, atomicInteger);

        Runnable runnable = () -> {
            try {
                calculationExplicitLocks.explicitLocks();
                calculatorSynchronized.synchronizedMethod();
                calculateAtomicObjects.atomicOperation();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        System.out.println("Task is done");
    }
}