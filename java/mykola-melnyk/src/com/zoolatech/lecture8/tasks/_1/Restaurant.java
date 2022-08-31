package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    static private ExecutorService chefsThreadPool = Executors.newFixedThreadPool(5);
    static private ExecutorService deliveryThreadPool = Executors.newFixedThreadPool(10);

    public static void acceptOrder(Order order) {
        chefsThreadPool.submit(() -> {
                System.out.println("Cooking: " + order.id());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            System.out.println(order.id() + " cooked.");
            deliveryThreadPool.submit(() -> {
                    System.out.println("Delivering: " + order.id());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(order.id() + " delivered.");

            });
            System.out.println(order.id() + " sent for delivery");
        });
    }

}
