package com.zoolatech.lecture6.tasks._2;

import java.util.Objects;

public record Order(String id, StoreType storeType, float price, String country) {
    private static int idCounter = 1;

    public Order(StoreType type, float price, String country) {
        this(String.valueOf(idCounter), type, price, country);
        idCounter++;
    }
}
