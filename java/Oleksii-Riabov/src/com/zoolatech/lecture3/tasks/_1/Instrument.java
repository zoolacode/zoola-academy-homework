package com.zoolatech.lecture3.tasks._1;

public class Instrument {
    private final String name;
    private final String sound;

    public String getName() {
        return name;
    }

    public Instrument(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public void sound() {
        System.out.println(sound);
    }
}
