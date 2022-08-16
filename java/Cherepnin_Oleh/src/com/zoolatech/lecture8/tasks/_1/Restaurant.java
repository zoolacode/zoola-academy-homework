package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private LinkedBlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    private ExecutorService staff = Executors.newCachedThreadPool();

    public void acceptOrder(Order order) {
        System.out.println(order + " is accepted");
        orders.offer(order);
    }

    public void makeOrders() {
        staff.submit(new Chief(orders));
        staff.submit(new DeliveryMan(orders));
    }

    public void close() {
        staff.shutdownNow();
        System.out.println("Restaurant closed");
    }
}
