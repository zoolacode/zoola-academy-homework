package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.LinkedBlockingQueue;

public class Chief implements Runnable {

    private LinkedBlockingQueue<Order> orders;

    public Chief(LinkedBlockingQueue<Order> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Order order = orders.take();
                System.out.println("Chief is cooking order#" + order.id());
                Thread.sleep(2000);
                orders.put(order);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
