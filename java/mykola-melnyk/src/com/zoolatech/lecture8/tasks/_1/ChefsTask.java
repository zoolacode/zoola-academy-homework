package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.ExecutorService;

public class ChefsTask implements Runnable{
    private final Order order;
    private final ExecutorService deliveryPool;
    public ChefsTask(Order order, ExecutorService deliveryPool) {
        this.order = order;
        this.deliveryPool = deliveryPool;
    }

    @Override
    public void run() {
        System.out.println("Cooking: " + order.id());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(order.id() + " cooked.");
        deliveryPool.submit(new DeliveryTask(order));
        System.out.println(order.id() + " sent for delivery");
    }
}
