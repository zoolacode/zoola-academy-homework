package com.zoolatech.lecture3.tasks._1;

public abstract class MusicalInstrument {
    private String instrumentName;

    public MusicalInstrument(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    abstract void playSound();
}

class Guitar extends MusicalInstrument {
    Guitar() {
        super("Guitar");
    }

    @Override
    void playSound() {
        System.out.println("*guitar sounds*");
    }
}

class Piano extends MusicalInstrument {
    Piano() {
        super("Piano");
    }

    @Override
    void playSound() {
        System.out.println("*piano sounds*");
    }
}

class Violin extends MusicalInstrument {
    Violin() {
        super("Violin");
    }

    @Override
    void playSound() {
        System.out.println("*violin sounds*");
    }
}
