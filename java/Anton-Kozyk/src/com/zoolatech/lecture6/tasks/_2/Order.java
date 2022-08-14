package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record Order(String id, String country, float price, Marketplace marketplace) {
    public float getPrice() {
        return price;
    }

    public static Map<String, Double> averagePrice(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.marketplace == Marketplace.STORE)
                .collect(Collectors.toMap(order -> order.id, Function.identity(), (prev, next) -> next))
                .values().stream()
                .collect(Collectors.groupingBy(order -> order.country, Collectors.averagingDouble(Order::getPrice)));
    }
}
