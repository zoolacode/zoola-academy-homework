package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.LinkedBlockingQueue;

public class Chief implements Runnable{
    private LinkedBlockingQueue<Order> newOrders;
    private LinkedBlockingQueue<Order> ordersInProgress;

    public Chief(LinkedBlockingQueue<Order> newOrders, LinkedBlockingQueue<Order> ordersInProgress) {
        this.newOrders = newOrders;
        this.ordersInProgress = ordersInProgress;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                Order orderToCook = newOrders.take();
                System.out.println("Chief " + Thread.currentThread().getId()+ " is cooking order " + orderToCook.id()+" for client " + orderToCook.customerName());
                Thread.sleep(4000);
                ordersInProgress.put(orderToCook);
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
