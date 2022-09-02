package com.zoolatech.lecture6.tasks._2;

import java.util.Objects;

enum Type {
    WEBSITE,
    STORE
}
public record Order (String id, Type orderType, float price, String country) {

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