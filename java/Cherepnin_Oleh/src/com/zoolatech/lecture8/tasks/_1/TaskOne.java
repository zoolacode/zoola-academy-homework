package com.zoolatech.lecture8.tasks._1;

import java.util.List;
import java.util.concurrent.*;

/**
 * Create a class Restaurant that’s able to accept orders from multiple customers (the order can just contain an id
 * and a customer name). The restaurant needs to have a couple of Chefs and DeliveryPerson. The first available chef
 * needs to pick up a new order and process it (the process can simply print an appropriate message and sleep for
 * a couple of seconds). When an order is ready, it should be passed to the first available DeliveryPerson,
 * which needs to deliver an order to a customer (also, just print an appropriate message and sleep for some time).
 * Use queues to synchronize order processing between customers, chefs and delivery persons. Note: both chefs and
 * delivery persons need to run in the separate thread.
 */
public class TaskOne {
    public static void main(String[] args) throws Exception {
        List<Order> orders = List.of(new Order(1, "Thomas"),
                new Order(2, "Victor"),
                new Order(3, "Simon"),
                new Order(4, "John"),
                new Order(5, "Jerry"),
                new Order(6, "Bob"),
                new Order(7, "Sally"));

        Restaurant restaurant = new Restaurant();
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                for (Order o : orders) {
                    restaurant.acceptOrder(o);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            }
        });
        thread.start();
        restaurant.makeOrders();
        thread.join();
        System.out.println("after join");
        restaurant.close();
    }
}

