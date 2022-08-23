package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Create a class Restaurant that’s able to accept orders from multiple customers (the order can just contain an id and a customer name).
The restaurant needs to have a couple of Chefs and DeliveryPerson.
The first available chef needs to pick up a new order and process it
(the process can simply print an appropriate message and sleep for a couple of seconds).
When an order is ready, it should be passed to the first available DeliveryPerson, which needs to deliver an order to a customer
(also, just print an appropriate message and sleep for some time).
Use queues to synchronize order processing between customers, chefs and delivery persons.
Note: both chefs and delivery persons need to run in the separate thread.
*/

public class Number1 {
    public static void main(String[] args) throws InterruptedException {
        Restaurant restaurant = new Restaurant();
        int id = 1;
        Order order = new Order(id, "Efe");

        BlockingQueue<String> orderQueue = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> ordersTaken = new ArrayBlockingQueue<>(1);

        Thread customerQueue = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    orderQueue.put(restaurant.acceptOrder(order));
                    Thread.sleep(2000);
                    System.out.println("added order number :" + (order.getId()) + " " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread chef = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String currentOrder = orderQueue.take();
                    Thread.sleep(2000);
                    System.out.println("Cooking order: " + currentOrder + " " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                    ordersTaken.put(currentOrder);
                    System.out.println("Preparing order to delivery person: " + currentOrder + " " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread deliveryPerson = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(2000);
                    System.out.println("Picked up and taking order back : " + ordersTaken.take() + " " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    order.getOrder();
                }
            }
        });

        customerQueue.setName("CUSTOMER");
        chef.setName("CHEF");
        deliveryPerson.setName("DELIVERY PERSON");

        customerQueue.start();
        chef.start();
        deliveryPerson.start();

    }
}

class Restaurant {

    public String acceptOrder(Order order) {
        return order.getId() + " " + order.getCustomerName();
    }
}

class Order {
    private final int id;
    private final String customerName;

    public Order(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void getOrder() {
        System.out.println("Order number : " + getId() + " is delivered to a customer by name: " + getCustomerName());
    }
}