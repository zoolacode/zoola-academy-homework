package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create a method that accepts a list of orders and returns a map of an average price of all store orders per
 * each country. Use Stream API to do this. The order has such properties: string id, enum type (WEBSITE, STORE),
 * float price (yeah, I know, but let’s simplify the code :)), string country. How would you change your code if
 * a list contains duplicate items with the same id?
 * Input: order1(“1”, “store”, 1.23, “Ukraine”),
 * order2(“2”, “store”, 4.56, “Ukraine”),
 * order3(“3”, “store”, 1.23, “USA”),
 * order4(“4”, “website”, 1.23, “USA”)
 * Output: “USA” -> 1.23, “Ukraine” -> 2.89
 */
public class TaskTwo {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(StoreType.STORE, 15.f, "USA"),
                new Order(StoreType.WEBSITE, 5.f, "USA"),
                new Order(StoreType.STORE, 19.2f, "USA"),
                new Order(StoreType.WEBSITE, 1.8f, "USA"),
                new Order(StoreType.STORE, 6f, "Ukraine"),
                new Order(StoreType.STORE, 8.5f, "Ukraine")
        );

        getAveragePriceInCountry(orders).
                forEach((k, v) -> System.out.println(k + " : " + v.floatValue()));
    }

    private static Map<String, Double> getAveragePriceInCountry(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCountry,
                        Collectors.averagingDouble(Order::getPrice)));
    }
}

