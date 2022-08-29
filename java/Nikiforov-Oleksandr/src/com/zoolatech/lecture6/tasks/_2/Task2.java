package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
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
                new Order("1", ShopType.STORE, 1.23f, "Ukraine"),
                new Order("2", ShopType.STORE, 4.56f, "Ukraine"),
                new Order("2", ShopType.STORE, 4.56f, "Ukraine"),
                new Order("3", ShopType.STORE, 1.23f, "USA"),
                new Order("3", ShopType.STORE, 1.25f, "USA"),
                new Order("4", ShopType.WEBSITE, 1.23f, "USA"));
        averagePrice(orders)
                .forEach((k, v) -> System.out.println(k + " -> " + String.format("%.2f", v)));
    }

    public static Map<String, Double> averagePrice(List<Order> orders) {
        return orders.stream()
                .filter(shop -> shop.type().equals(ShopType.STORE))
                .filter(distinctByKey(Order::id))
                .collect(Collectors.groupingBy(Order::country,
                        Collectors.averagingDouble(Order::price)));
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}


record Order(String id, ShopType type, float price, String country) {

}