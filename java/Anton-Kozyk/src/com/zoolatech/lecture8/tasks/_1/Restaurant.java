package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Create a class Restaurant that’s able to accept orders from multiple customers
 * (the order can just contain an id and a customer name). The restaurant needs to
 * have a couple of Chefs and DeliveryPerson. The first available chef needs to pick
 * up a new order and process it (the process can simply print an appropriate message
 * and sleep for a couple of seconds). When an order is ready, it should be passed
 * to the first available DeliveryPerson, which needs to deliver an order to a
 * customer (also, just print an appropriate message and sleep for some time). Use
 * queues to synchronize order processing between customers, chefs and delivery
 * persons. Note: both chefs and delivery persons need to run in the separate thread.
 */

public class Restaurant {
    public static void main(String[] args) {
        record Order(String name, int id) {
            @Override
            public String toString() {
                return "ID " + id + ", for: " + name;
            }
        }

        LinkedBlockingQueue<Order> newOrders = new LinkedBlockingQueue<>();
        String[] customerNames = {"Jack", "Alban", "Sam", "James", "Merry", "Mac"};
        Thread customers = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                int id = 1;
                for (String name : customerNames) {
                    try {
                        Order newOrder = new Order(name, id);
                        System.out.println("\nNew order from " + newOrder.name + ". ID: " + newOrder.id);
                        newOrders.put(newOrder);
                        Thread.sleep(4000);
                        id++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        });

        LinkedBlockingQueue<Order> ordersInProgress = new LinkedBlockingQueue<>();
        Thread chefs = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Order order = newOrders.take();
                    System.out.println(order + " -> taken by the chef");
                    Thread.sleep(2000);
                    ordersInProgress.put(order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread deliveryPerson = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.println(ordersInProgress.take() + " -> delivering by delivery person...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        customers.start();
        chefs.start();
        deliveryPerson.start();
    }
}
