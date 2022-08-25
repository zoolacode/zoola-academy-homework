package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public class Musician {
    private String name;
    private MusicalInstrument instrument;

    Musician(String name, MusicalInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public String getName() {
        return name;
    }

    void playInstrument() {
        instrument.playSound();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return Objects.equals(name, musician.name);
    }

    void printInfo() {
        System.out.println("Name: " + name);
        System.out.println(this.instrument.getInstrumentName());
        instrument.playSound();
    }
}
