package com.zoolatech.lecture8.tasks._1;

import java.util.List;

/**
 * Create a class Restaurant that’s able to accept orders from multiple customers (the order can just contain an id
 * and a customer name). The restaurant needs to have a couple of Chefs and DeliveryPerson.
 * The first available chef needs to pick up a new order and process it (the process can simply print an appropriate
 * message and sleep for a couple of seconds). When an order is ready, it should be passed to the first available
 * DeliveryPerson, which needs to deliver an order to a customer (also, just print an appropriate message and sleep
 * for some time). Use queues to synchronize order processing between customers, chefs and delivery persons.
 * Note: both chefs and delivery persons need to run in the separate thread.
 */

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        List<Order> orders = List.of(new Order(1, "Steven"),
                new Order(2, "David"),
                new Order(3, "Adam"),
                new Order(4, "Chester"),
                new Order(5,"Christopher"),
                new Order(6,"Kelly"),
                new Order(7,"Peter"),
                new Order(8,"Leslie"),
                new Order(9, "Joshua"),
                new Order(10, "Roderick"),
                new Order(11, "Patricia"),
                new Order(12, "Carol"));
        Restaurant restaurant = new Restaurant();
        Thread thread = new Thread(() ->{
            while (!Thread.currentThread().isInterrupted()) {
                for(Order o:orders){
                    restaurant.acceptOrders(o);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                break;
            }
        });
        thread.start();
        restaurant.work();
        thread.join();
        restaurant.close();
    }
}
