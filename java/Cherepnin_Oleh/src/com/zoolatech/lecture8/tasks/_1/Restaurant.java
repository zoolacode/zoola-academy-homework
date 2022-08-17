package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private LinkedBlockingQueue<Order> acceptedOrders = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Order> ordersInProcess = new LinkedBlockingQueue<>();
    private ExecutorService staff = Executors.newCachedThreadPool();

    public void acceptOrder(Order order) {
        System.out.println(order + " is accepted");
        acceptedOrders.offer(order);
    }

    public void makeOrders() {
        staff.submit(new Chief());
        staff.submit(new Chief());
        staff.submit(new DeliveryPerson(ordersInProcess));
        staff.submit(new DeliveryPerson(ordersInProcess));
    }

    public void close() {
        staff.shutdownNow();
        System.out.println("Restaurant closed");
    }

    class Chief implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Order order = acceptedOrders.take();
                    System.out.println("Chief #" + Thread.currentThread().getId() + " is cooking order #" + order.id());
                    Thread.sleep(2000);
                    ordersInProcess.put(order);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
