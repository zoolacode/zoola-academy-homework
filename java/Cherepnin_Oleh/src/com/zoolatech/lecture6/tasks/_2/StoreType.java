package com.zoolatech.lecture6.tasks._2;

public enum StoreType {
    STORE("store"),
    WEBSITE("website");
    private String name;

    StoreType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
