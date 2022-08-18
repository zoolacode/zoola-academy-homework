package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record Order(String id, String country, float price, Marketplace marketplace) {
    public float getPrice() {
        return price;
    }

    public static Map<String, Double> averagePrice(List<Order> orders) {
        return orders.stream()
                .filter(order -> order.marketplace == Marketplace.STORE)
                .distinct()
                .collect(Collectors.groupingBy(order -> order.country, Collectors.averagingDouble(Order::getPrice)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }
}
