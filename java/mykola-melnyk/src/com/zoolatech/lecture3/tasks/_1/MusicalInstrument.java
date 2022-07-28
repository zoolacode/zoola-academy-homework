package com.zoolatech.lecture3.tasks._1;

public class MusicalInstrument {
    private String name;
    private String sound;
    public MusicalInstrument(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }
    public String playSound() {
        return this.sound;
    }
}

class Vocals extends MusicalInstrument {
    public Vocals(String name, String sound) {
        super(name, sound);
    }
}

class Drum extends MusicalInstrument {
    public Drum(String name, String sound) {
        super(name, sound);
    }
}

class Guitar extends MusicalInstrument {
    public Guitar(String name, String sound) {
        super(name, sound);
    }
}

class Piano extends MusicalInstrument {
    public Piano(String name, String sound) {
        super(name, sound);
    }
}