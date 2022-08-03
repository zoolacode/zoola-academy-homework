package com.zoolatech.lecture6.tasks._2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface OrderCalc {
    default Map<String, Double> orderPerEachCountry(List<Order> orderList) {
        return orderList.stream()
                .collect(Collectors.groupingBy(Order::getCountry, Collectors.averagingDouble(Order::getPrice)));
    }
}