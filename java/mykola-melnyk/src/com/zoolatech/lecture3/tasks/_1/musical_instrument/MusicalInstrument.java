package com.zoolatech.lecture3.tasks._1.musical_instrument;

public class MusicalInstrument {
    private String name;
    private String sound;

    public MusicalInstrument(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public void playSound() {
        System.out.println(sound);
    }

    public String getName(){
        return name;
    }

    public String getSound() {
        return sound;
    }
}

