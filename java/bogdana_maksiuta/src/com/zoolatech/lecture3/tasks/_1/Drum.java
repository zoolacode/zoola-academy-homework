package com.zoolatech.lecture3.tasks._1;

public class Drum extends MusicalInstrument {
    public Drum(String name, String sound) {
        super(name, sound);
    }

    void play() {
        super.play();
    }

    @Override
    public String toString() {
        return "drum";
    }
}
