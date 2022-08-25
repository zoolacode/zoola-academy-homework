package com.zoolatech.lecture7.tasks._2;

/**
 * Define a class that represents a calculator. The class should provide methods that accept another value and perform
 * addition or subtraction operation on a value stored in a calculator instance. The class should also provide a method
 * to get a current value. The class should work only with integer values. Assume all operation results fit into
 * the range of values for a current value type. Assume all operations will be executed from multiple threads,
 * so make sure the class is thread-safe. Implement three versions of the class:
 * using explicit locks
 * using synchronized
 * using atomic objects
 */

public class TaskTwo {
    public static void main(String[] args) throws InterruptedException {
        Calculator calc1 = new AtomicCalculator();
//        Calculator calc1 = new LockCalculator();
//        Calculator calc1 = new SyncCalculator();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                calc1.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                calc1.add(i);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Result: " + calc1.getValue());
    }
}
