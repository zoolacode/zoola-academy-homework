package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create a method that accepts a list of orders and returns a map of an average price of all store orders
 * per each country. Use Stream API to do this. The order has such properties: string id, enum type (WEBSITE, STORE),
 * float price (yeah, I know, but let’s simplify the code :)), string country. How would you change your code
 * if a list contains duplicate items with the same id?
 */

public class Task2 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("1", ShopType.Store, 1.23f, "Ukraine"),
                new Order("2", ShopType.Store, 4.56f, "Ukraine"),
                new Order("3", ShopType.Store, 1.23f, "USA"),
                new Order("4", ShopType.Website, 1.23f, "USA"));
        averagePrice(orders)
                .forEach((k, v) -> System.out.println(k + " -> " + String.format("%.2f", v)));
    }

    public static Map<String, Double> averagePrice(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCountry,
                        Collectors.averagingDouble(Order::getPrice)));
    }
}