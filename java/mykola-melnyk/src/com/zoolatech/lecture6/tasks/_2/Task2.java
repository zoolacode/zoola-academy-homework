package com.zoolatech.lecture6.tasks._2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.zoolatech.lecture6.tasks._2.Type.STORE;
import static com.zoolatech.lecture6.tasks._2.Type.WEBSITE;
import static java.util.stream.Collectors.averagingDouble;

/**
 * Create a method that accepts a list of orders and returns a map of an average price of all store orders
 * per each country. Use Stream API to do this. The order has such properties: string id,
 * enum type (WEBSITE, STORE), float price (yeah, I know, but let’s simplify the code :)),
 * string country. How would you change your code if a list contains duplicate items with the same id?
 * Input: order1(“1”, “store”, 1.23, “Ukraine”), order2(“2”, “store”, 4.56, “Ukraine”),
 * order3(“3”, “store”, 1.23, “USA”), order4(“4”, “website”, 1.23, “USA”)
 * Output: “USA” -> 1.23, “Ukraine” -> 2.89
 */

public class Task2 {

    public static Map<String, Double> grouping(ArrayList<Order> myOrders) {
        return myOrders.stream().filter(e -> e.orderType() == STORE)
                .collect(Collectors.groupingBy(Order::country, averagingDouble(Order::price)));
    }

    public static Map<String, Double> groupingDistinct(ArrayList<Order> myOrders) {
        return myOrders.stream().filter(e -> e.orderType() == STORE)
                .distinct()
                .collect(Collectors.groupingBy(Order::country, averagingDouble(Order::price)));
    }

    public static void main(String[] args) {
        Order order1 = new Order("1", STORE, 1.23f, "Ukraine");
        Order order2 = new Order("2", STORE, 4.56f, "Ukraine");
        Order order3 = new Order("3", STORE, 1.23f, "USA");
        Order order4 = new Order("4", WEBSITE, 1.23f, "USA");
        Order order5 = new Order("4", WEBSITE, 9.9f, "USA");
        ArrayList<Order> myOrders = new ArrayList<>();
        Collections.addAll(myOrders, order1, order2, order3, order4, order5);
        System.out.println(grouping(myOrders));
        System.out.println(groupingDistinct(myOrders));
    }
}