package com.zoolatech.lecture3.tasks._1;

public class Trumpet extends MusicalInstrument {

    public Trumpet(String name, String sound) {
        super(name, sound);
    }

    void play() {
        super.play();
    }

    @Override
    public String toString() {
        return "trumpet";
    }
}
