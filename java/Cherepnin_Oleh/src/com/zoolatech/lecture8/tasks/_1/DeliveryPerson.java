package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.LinkedBlockingQueue;

public class DeliveryPerson implements Runnable {

    private LinkedBlockingQueue<Order> orders;

    public DeliveryPerson(LinkedBlockingQueue<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Order order = orders.take();
                System.out.println("Delivery man is delivering order#" + order.id());
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
