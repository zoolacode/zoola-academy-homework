package com.zoolatech.lecture3.tasks._1;

public class Percussion implements Instrument{

    public static final String NAME = "percussion";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void sound() {
        System.out.println("bom-bom-tun-tun");
    }
}
