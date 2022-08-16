package com.zoolatech.lecture6.tasks._2;

import java.util.Objects;

public record Order(String id, StoreType storeType, float price, String country) {
    private static int idCounter = 1;

    public Order(StoreType type, float price, String country) {
        this(String.valueOf(idCounter), type, price, country);
        idCounter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Float.compare(order.price, price) == 0
                && Objects.equals(id, order.id)
                && storeType == order.storeType
                && Objects.equals(country, order.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeType, price, country);
    }

    @Override
    public String toString() {
        return "order#" + id + "(\"" + id +
                "\", \"" + storeType +
                "\", " + price +
                ", \"" + country + "\")";
    }
}
