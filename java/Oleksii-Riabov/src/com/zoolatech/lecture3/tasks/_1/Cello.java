package com.zoolatech.lecture3.tasks._1;

public class Cello implements Instrument{

    public static final String NAME = "cello";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void sound() {
        System.out.println("uuw-uuw-uuw");
    }
}
