package com.zoolatech.lecture7.tasks._1;

import java.util.Random;

/**
 * Create a new task that infinitely prints random numbers to the output. Create a new child thread and run this task
 * using the created thread. Make the main thread sleep for some time (at least 100ms), and then stop the child thread.
 * The task should be designed in such a way that it should properly react to the stop signal. The main thread should
 * wait till the child thread is completed, and only finish the program.
 */
public class TaskOne {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            Random random = new Random();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(random.nextInt());
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        };
        Thread thread = new Thread(task);
/*
        Thread thread = new Thread(() -> {
            Random random = new Random();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(random.nextInt());
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        });
*/
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();

        System.out.println(Thread.currentThread().getName() + " finished");
    }
}

