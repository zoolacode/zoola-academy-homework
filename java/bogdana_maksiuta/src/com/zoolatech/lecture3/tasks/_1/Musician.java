package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public class Musician {
    private String name;
    MusicalInstrument instrument;

    public Musician(String name, MusicalInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public void getNameAndInstrument(Musician musician) {
        System.out.println(musician);
    }

    public void playMusic() {
        instrument.play();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return Objects.equals(name, musician.name) && Objects.equals(instrument, musician.instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, instrument);
    }

    @Override
    public String toString() {
        return "Musician " + name +
                " who is playing on " + instrument;
    }
}

