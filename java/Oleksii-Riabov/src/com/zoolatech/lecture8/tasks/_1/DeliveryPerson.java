package com.zoolatech.lecture8.tasks._1;

public record DeliveryPerson(String deliveryPersonName) {
    public void deliverOrder(Order order) {
        System.out.println(deliveryPersonName + " delivering order #: " + order.id() + " to: " + order.customerName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.err.println("Order #: " + order.id() + " is complete by: " + deliveryPersonName);
    }
}
