package com.zoolatech.lecture3.tasks._1;

public class Guitar extends MusicalInstrument {
    public Guitar(String name, String sound) {
        super(name, sound);
    }

    void play() {
        super.play();
    }

    @Override
    public String toString() {
        return "guitar";
    }
}
