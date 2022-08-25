package com.zoolatech.lecture8.tasks._1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private ExecutorService staff = Executors.newCachedThreadPool();
    private LinkedBlockingQueue<Order> newOrders = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Order> ordersInProgress = new LinkedBlockingQueue<>();

    public void acceptOrders(Order newOrder){
        System.out.println("Order "+ newOrder.id() + " accepted");
        newOrders.add(newOrder);
    }

    public void close(){
        staff.shutdown();
        System.out.println("Restaurant close. Comeback tomorrow!");
    }

    public void work(){
        staff.submit(new Chief(newOrders,ordersInProgress));
        staff.submit(new Chief(newOrders,ordersInProgress));
        staff.submit(new DeliveryPerson(ordersInProgress));
        staff.submit(new DeliveryPerson(ordersInProgress));
        staff.submit(new DeliveryPerson(ordersInProgress));
        staff.submit(new DeliveryPerson(ordersInProgress));
        staff.submit(new DeliveryPerson(ordersInProgress));
    }
}
