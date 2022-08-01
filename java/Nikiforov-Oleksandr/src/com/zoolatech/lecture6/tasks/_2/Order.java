package com.zoolatech.lecture6.tasks._2;

public class Order {
    private String id;
    private ShopType type;
    private float price;
    private String country;

    public Order(String id, ShopType type, float price, String country) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.country = country;
    }


    public float getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", country='" + country + '\'' +
                '}';
    }
}
