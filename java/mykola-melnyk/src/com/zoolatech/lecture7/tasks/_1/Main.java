package com.zoolatech.lecture7.tasks._1;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            while (!Thread.currentThread().isInterrupted())
                System.out.println((int) (Math.random() * 10));
        };
        var t = new Thread(r);
        t.start();
        Thread.sleep(100);
        t.interrupt();
    }
}
