package com.zoolatech.lecture3.tasks._1;

public class Violin implements Instrument {

    public static final String NAME = "violin";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void sound() {
        System.out.println("view-view-view");
    }
}
