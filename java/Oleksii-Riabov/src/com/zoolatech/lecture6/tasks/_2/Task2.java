package com.zoolatech.lecture6.tasks._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Create a method that accepts a list of orders and returns a map of an average price
 * of all store orders per each country. Use Stream API to do this. The order has such
 * properties: string id, enum type (WEBSITE, STORE), float price (yeah, I know, but
 * let’s simplify the code :)), string country. How would you change your code if a
 * list contains duplicate items with the same id?
 * aInput: order1(“1”, “store”, 1.23, “Ukraine”), order2(“2”, “store”, 4.56, “Ukraine”),
 * order3(“3”, “store”, 1.23, “USA”), order4(“4”, “website”, 1.23, “USA”)
 * Output: “USA” -> 1.23, “Ukraine” -> 2.89
 */

public class Task2 {

    public static void main(String[] args) {
        List<Order> list = new ArrayList<>();
        list.add(new Order("1", "store", 1.23f, "Ukraine"));
        list.add(new Order("2", "store", 4.56f, "Ukraine"));
        list.add(new Order("3", "store", 1.23f, "USA"));
        list.add(new Order("4", "website", 1.23f, "USA"));
        list.add(new Order("4", "website", 10.23f, "USA"));

        System.out.println(getAverageOrderPrice(list));
    }

    public static Map<String, Double> getAverageOrderPrice(List<Order> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.groupingBy(Order::country,
                        HashMap::new,
                        Collectors.averagingDouble(Order::price)));
    }

    public record Order(String id, StoreOrders storeOrders, float price, String country) {

        public enum StoreOrders {
            WEBSITE, STORE
        }

        public Order(String id, String storeOrders, float price, String country) {
            this(id, StoreOrders.valueOf(storeOrders.toUpperCase()), price, country);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return id.equals(order.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}

