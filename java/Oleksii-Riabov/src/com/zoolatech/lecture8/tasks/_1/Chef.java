package com.zoolatech.lecture8.tasks._1;

public record Chef(String name) {
    public Order processOrder(Order order) {
        System.out.println(name + " pick up an order #: " + order.id() + " and process it");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.err.println(name + " give an order #: " + order.id() + " to delivery");
        return order;
    }
}
