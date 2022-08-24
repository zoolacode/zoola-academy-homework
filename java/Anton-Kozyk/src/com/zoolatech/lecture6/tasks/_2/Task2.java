package com.zoolatech.lecture6.tasks._2;

import java.util.List;

/**
 * Create a method that accepts a list of orders and returns a map of
 * an average price of all store orders per each country. Use Stream API to
 * do this. The order has such properties: string id, enum type (WEBSITE,
 * STORE), float price, string country. How would you change your code if
 * a list contains duplicate items with the same id?
 */

public class Task2 {
    public static void main(String[] args) {
        Order order1 = new Order("1", "Ukraine", 150000, Marketplace.STORE);
        Order order2 = new Order("1", "Ukraine", 200, Marketplace.STORE);
        Order order3 = new Order("2", "Ukraine", 500, Marketplace.STORE);
        Order order4 = new Order("3", "Ukraine", 200000, Marketplace.WEBSITE);
        Order order5 = new Order("4", "USA", 100, Marketplace.STORE);
        Order order6 = new Order("5", "USA", 10000, Marketplace.STORE);
        List<Order> orders = List.of(order1, order2, order3, order4, order5, order6);

        Order.averagePrice(orders).forEach((k, v) -> System.out.println(k + " -> " + v));
        System.out.println();
    }
}
