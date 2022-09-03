package com.zoolatech.lecture7.tasks._1;

/*
Create a new task that infinitely prints random numbers to the output.
Create a new child thread and run this task using the created thread.
Make the main thread sleep for some time (at least 100ms), and then stop the child thread.
The task should be designed in such a way that it should properly react to the stop signal.
The main thread should wait till the child thread is completed, and only finish the program.
 */

public class Number1 {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                printNumber(Math.random());
            }

            System.out.println("Stopping thread: " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.setName("CHILD");
        Thread.currentThread().setName("MAIN");

        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        thread.join();
    }

    private static void printNumber(Double aDouble) {
        System.out.println(Thread.currentThread().getName() + " " + aDouble);
    }
}