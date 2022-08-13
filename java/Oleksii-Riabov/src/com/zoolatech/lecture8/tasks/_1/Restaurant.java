package com.zoolatech.lecture8.tasks._1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Create a class Restaurant that’s able to accept orders from multiple
 * customers (the order can just contain an id and a customer name).
 * The restaurant needs to have a couple of Chefs and DeliveryPerson.
 * The first available chef needs to pick up a new order and process it
 * (the process can simply print an appropriate message and sleep for a
 * couple of seconds). When an order is ready, it should be passed to
 * the first available DeliveryPerson, which needs to deliver an order
 * to a customer (also, just print an appropriate message and sleep for
 * some time). Use queues to synchronize order processing between
 * customers, chefs and delivery persons. Note: both chefs and delivery
 * persons need to run in the separate thread.
 */

public class Restaurant {

    public static void main(String[] args) {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1, "Taras"));
        orderList.add(new Order(2, "Petya"));
        orderList.add(new Order(3, "Sasha"));
        orderList.add(new Order(4, "Vika"));
        orderList.add(new Order(5, "Kolya"));

        Chef chef = new Chef("Chef1");
        Chef chef2 = new Chef("Chef2");
        Chef chef3 = new Chef("Chef3");

        DeliveryPerson deliveryPerson = new DeliveryPerson("DeliveryMan1");
        DeliveryPerson deliveryPerson2 = new DeliveryPerson("DeliveryMan2");

        BlockingQueue<Order> queue1 = new ArrayBlockingQueue<>(5);
        BlockingQueue<Order> queue2 = new ArrayBlockingQueue<>(5);

        Thread putElements = new Thread(() -> orderList.forEach(e -> {
            try {
                queue1.put(e);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }));

        Thread processChef1 = new Thread(() -> {
            do {
                try {
                    queue2.put(chef.processOrder(queue1.take()));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (!queue1.isEmpty());
        });

        Thread processChef2 = new Thread(() -> {
            do {
                try {
                    queue2.put(chef2.processOrder(queue1.take()));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (!queue1.isEmpty());
        });

        Thread processChef3 = new Thread(() -> {
            do {
                try {
                    queue2.put(chef3.processOrder(queue1.take()));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (!queue1.isEmpty());
        });

        Thread processDelivery1 = new Thread(() -> {
            do {
                try {
                    deliveryPerson.deliverOrder(queue2.take());
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            } while (!queue2.isEmpty());
        });

        Thread processDelivery2 = new Thread(() -> {
            do {
                try {
                    deliveryPerson2.deliverOrder(queue2.take());
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            } while (!queue2.isEmpty());
        });

        putElements.start();
        processChef1.start();
        processChef2.start();
        processChef3.start();
        processDelivery1.start();
        processDelivery2.start();
    }
}
