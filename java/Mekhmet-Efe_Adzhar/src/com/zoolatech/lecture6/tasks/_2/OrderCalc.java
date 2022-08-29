package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class OrderCalc {
    public Map<String, Double> orderPerEachCountry(List<Order> orderList) {
       return orderList.stream()
                .filter(order -> order.orderType().equals(OrderType.STORE))
                .distinct()
                .collect(Collectors.groupingBy(Order::country, Collectors.averagingDouble(Order::price)));
    }
}