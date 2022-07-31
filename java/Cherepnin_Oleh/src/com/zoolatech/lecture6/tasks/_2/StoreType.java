package com.zoolatech.lecture6.tasks._2;

public enum StoreType {
    STORE("store"),
    WEBSITE("website");
    private String string;

    StoreType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
