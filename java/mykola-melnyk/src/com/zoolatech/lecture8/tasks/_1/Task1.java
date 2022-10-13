package com.zoolatech.lecture8.tasks._1;

/**
 * Create a class Restaurant that’s able to accept orders from multiple customers (the order can just
 * contain an id and a customer name). The restaurant needs to have a couple of Chefs and
 * DeliveryPerson. The first available chef needs to pick up a new order and process it
 * (the process can simply print an appropriate message and sleep for a couple of seconds).
 * When an order is ready, it should be passed to the first available DeliveryPerson, which
 * needs to deliver an order to a customer (also, just print an appropriate message and sleep
 * for some time). Use queues to synchronize order processing between customers, chefs and
 * delivery persons. Note: both chefs and delivery persons need to run in the separate thread.
 */

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Restaurant zoolaBar = new Restaurant();
        for (int i = 1; i <= 10;i++) {
            Order order = new Order(i,"customer " + i);
            zoolaBar.acceptOrder(order);
        }

        Thread.sleep(500);

        zoolaBar.close();
    }

}
