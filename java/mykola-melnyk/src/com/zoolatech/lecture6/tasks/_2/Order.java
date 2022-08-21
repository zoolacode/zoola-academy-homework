package com.zoolatech.lecture6.tasks._2;

import java.util.Objects;

enum Type {
    WEBSITE,
    STORE
}
public class Order {
    private final String id;
    private final Type orderType;
    private final float price;
    private final String country;

    public Order(String id, Type orderType, float price, String country) {
        this.id = id;
        this.orderType = orderType;
        this.price = price;
        this.country = country;
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

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }
}
