package com.zoolatech.lecture3.tasks._1;

public class Vocal implements Instrument{

    public static final String NAME = "vocal";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void sound() {
        System.out.println("Wir sind des Geyers schwarzer Haufen...");
    }
}
