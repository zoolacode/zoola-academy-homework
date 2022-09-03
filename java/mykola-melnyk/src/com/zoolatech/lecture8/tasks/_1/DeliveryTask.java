package com.zoolatech.lecture8.tasks._1;

public class DeliveryTask implements Runnable{
    private final Order order;

    public DeliveryTask(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        System.out.println("Delivering: " + order.id());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(order.id() + " delivered.");
    }
}
