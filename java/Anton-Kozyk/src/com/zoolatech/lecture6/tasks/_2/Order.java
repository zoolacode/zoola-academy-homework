package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Order {
    private String id;
    private String country;
    private float price;
    private Marketplace marketplace;

    public float getPrice() {
        return price;
    }

    public Order(String id, String country, float price, String marketplace) {
        this.id = id;
        this.country = country;
        this.price = price;
        this.marketplace = Marketplace.valueOf(marketplace.toUpperCase());
    }

    public static Map<String, Double> averagePrice(List<Order> orders) {
        Map<String, Order> uniqOrders = orders.stream() //with this map we can be sure that no two orders will have the same id
                .collect(Collectors.toMap(order -> order.id, Function.identity(), (prev, next) -> next));

        return uniqOrders.values().stream()
                .filter(order -> order.marketplace == Marketplace.STORE)
                .collect(Collectors.groupingBy(order -> order.country, Collectors.averagingDouble(Order::getPrice)));
    }
}
