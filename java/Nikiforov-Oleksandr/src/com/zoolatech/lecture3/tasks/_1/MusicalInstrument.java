package com.zoolatech.lecture3.tasks._1;

public abstract class MusicalInstrument {
    private String sound;
    private String name;

    public MusicalInstrument(String sound, String name) {
        this.sound = sound;
        this.name = name;
    }

    void play() {
        System.out.println(this.sound);
    }
}
