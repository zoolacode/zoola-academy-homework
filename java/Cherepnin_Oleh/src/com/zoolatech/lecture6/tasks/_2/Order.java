package com.zoolatech.lecture6.tasks._2;

import java.util.Objects;

public class Order {
    private String id;
    private StoreType type;
    private float price;
    private String country;
    private static int idCounter = 1;

    public Order(StoreType type, float price, String country) {
        this.id = String.valueOf(idCounter);
        this.type = type;
        this.price = price;
        this.country = country;
        idCounter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Float.compare(order.getPrice(), getPrice()) == 0 && getId().equals(order.getId()) && getType() == order.getType() && getCountry().equals(order.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getPrice(), getCountry());
    }

    @Override
    public String toString() {
        return "order" + id + "(\"" + id +
                "\", \"" + type +
                "\", " + price +
                ", \"" + country + "\")";
    }

    public String getId() {
        return id;
    }

    public StoreType getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }
}
