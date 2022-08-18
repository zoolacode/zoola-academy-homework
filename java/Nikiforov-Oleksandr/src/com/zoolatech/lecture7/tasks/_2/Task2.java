package com.zoolatech.lecture7.tasks._2;

/**
 * Define a class that represents a calculator. The class should provide methods that accept another value and perform
 * addition or subtraction operation on a value stored in a calculator instance. The class should also provide
 * a method to get a current value. The class should work only with integer values. Assume all operation results
 * fit into the range of values for a current value type. Assume all operations will be executed from multiple threads,
 * so make sure the class is thread-safe. Implement three versions of the class:
 * using explicit locks
 * using synchronized
 * using atomic objects
 */

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        //ExplicitLocksCalculator calculator = new ExplicitLocksCalculator(25);
        //SynchronizedCalculator calculator = new SynchronizedCalculator(25);
        AtomicCalculator calculator = new AtomicCalculator(25);
        Thread threadAdd = new Thread(() -> {
            for (int i = 25; i > 0; i--) {
                calculator.add(i);
                System.out.println(Thread.currentThread().getName() + " value " + calculator.getValue());
            }
        });

        Thread threadSubtract = new Thread(() -> {
            for (int j = 20; j > 0; j--) {
                calculator.subtract(j);
                System.out.println(Thread.currentThread().getName() + " value " + calculator.getValue());
            }
        });

        threadAdd.start();
        threadSubtract.start();
        threadAdd.join();
        threadSubtract.join();
    }
}
