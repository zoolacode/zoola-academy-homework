package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.LinkedBlockingQueue;

public class DeliveryPerson implements Runnable{
    private LinkedBlockingQueue<Order> ordersInProgress;

    public DeliveryPerson(LinkedBlockingQueue<Order> ordersInProgress) {
        this.ordersInProgress = ordersInProgress;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                Order orderToCook = ordersInProgress.take();
                System.out.println("Courier " + Thread.currentThread().getId()+ " drive order " + orderToCook.id()+" to client " + orderToCook.customerName());
                Thread.sleep(12000);
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
