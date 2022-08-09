package com.zoolatech.lecture7.tasks._2;

/**
 * Define a class that represents a calculator. The class should provide
 * methods that accept another value and perform addition or subtraction
 * operation on a value stored in a calculator instance. The class should
 * also provide a method to get a current value. The class should work
 * only with integer values. Assume all operation results fit into the
 * range of values for a current value type. Assume all operations will
 * be executed from multiple threads, so make sure the class is
 * thread-safe. Implement three versions of the class:
 * using explicit locks
 * using synchronized
 * using atomic objects
 */

public class Task2 {

    public static void main(String[] args) throws InterruptedException {
        ExplicitLockCalculator explicitLockCalculator = new ExplicitLockCalculator(100);
        SynchronizedCalculator synchronizedCalculator = new SynchronizedCalculator(100);
        AtomicCalculator atomicCalculator = new AtomicCalculator(100);

        Runnable additionTask = () -> {
            for (int i = 0; i < 10; i++) {
                explicitLockCalculator.add(200);
                synchronizedCalculator.add(200);
                atomicCalculator.add(200);
            }
        };

        Runnable subtractionTask = () -> {
            for (int i = 0; i < 10; i++) {
                explicitLockCalculator.subtract(100);
                synchronizedCalculator.subtract(100);
                atomicCalculator.subtract(100);
            }
        };

        Thread[] additionThread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            additionThread[i] = new Thread(additionTask);
            additionThread[i].start();
        }

        Thread[] subtractionThread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            subtractionThread[i] = new Thread(subtractionTask);
            subtractionThread[i].start();
        }

        for (Thread thread : additionThread) {
            thread.join();
        }
        for (Thread thread : subtractionThread) {
            thread.join();
        }

        System.out.println("ExplicitLockCalculator calculations result: " + explicitLockCalculator.getValue());
        System.out.println("SynchronizedCalculator calculations result: " + synchronizedCalculator.getValue());
        System.out.println("AtomicCalculator calculations result: " + atomicCalculator.getValue());
    }
}
