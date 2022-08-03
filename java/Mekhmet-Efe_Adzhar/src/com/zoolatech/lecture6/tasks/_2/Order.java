package com.zoolatech.lecture6.tasks._2;

import java.util.Objects;

record Order(String id, OrderType orderType, float price, String country) {

    public String getCountry() {
        return country;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Float.compare(order.price, price) == 0 && Objects.equals(id, order.id) && Objects.equals(country, order.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}