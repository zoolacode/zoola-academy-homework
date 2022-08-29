package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public class Musician {
    private final String name;
    private final MusicalInstrument instrument;

    public Musician(String name, MusicalInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
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
        return "Musician " +
                name +
                " playing instrument " + instrument;

    }

    public void outputMusician() {
        System.out.println(this);
        instrument.play();
    }

    public MusicalInstrument getInstrument() {
        return instrument;
    }
}
