package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private final ExecutorService chefsThreadPool = Executors.newFixedThreadPool(5);
    private final ExecutorService deliveryThreadPool = Executors.newFixedThreadPool(10);


    public void acceptOrder(Order order) {
        chefsThreadPool.submit(new ChefsTask (order, deliveryThreadPool));
    }
    public void close() throws InterruptedException {
        chefsThreadPool.awaitTermination(500, TimeUnit.MILLISECONDS);
        chefsThreadPool.shutdown();
        deliveryThreadPool.shutdown();
    }
}
