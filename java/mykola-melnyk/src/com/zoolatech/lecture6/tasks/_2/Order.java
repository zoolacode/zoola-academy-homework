package com.zoolatech.lecture6.tasks._2;

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
