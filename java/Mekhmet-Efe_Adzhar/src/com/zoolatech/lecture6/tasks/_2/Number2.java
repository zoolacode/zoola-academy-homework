package com.zoolatech.lecture6.tasks._2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
Create a method that accepts a list of orders and returns a map of an average price of all store orders per each country.
Use Stream API to do this.
The order has such properties:
string id, enum type (WEBSITE, STORE), float price, string country.
How would you change your code if a list contains duplicate items with the same id?
Input:
order1(“1”, “store”, 1.23, “Ukraine”),
order2(“2”, “store”, 4.56, “Ukraine”),
order3(“3”, “store”, 1.23, “USA”),
order4(“4”, “website”, 1.23, “USA”)
Output: “USA” -> 1.23, “Ukraine” -> 2.89
*/

public class Number2 implements OrderCalc{
    public static void main(String[] args) {

        Order orderForUkraine = new Order("1", OrderType.STORE, 1.23F, "Ukraine");
        Order secondOrderForUkraine = new Order("2", OrderType.STORE, 4.56F, "Ukraine");
        Order orderForUSA = new Order("3", OrderType.STORE, 1.23F, "USA");
        Order secondOrderForUSA = new Order("4", OrderType.WEBSITE, 1.23F, "USA");

        List<Order> orderList = new ArrayList<>();
        orderList.add(orderForUkraine);
        orderList.add(secondOrderForUkraine);
        orderList.add(orderForUSA);
        orderList.add(secondOrderForUSA);

        Number2 number2 = new Number2();

        number2.orderPerEachCountry(orderList)
                .forEach((key, value) -> System.out.println(key + " -> " + String.format("%.2f", value)));;
    }
}