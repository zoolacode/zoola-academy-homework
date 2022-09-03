package com.zoolatech.lecture3.tasks._1.musician;

import com.zoolatech.lecture3.tasks._1.musical_instrument.MusicalInstrument;

import java.util.Objects;

public class Musician {
    private String name;
    private MusicalInstrument instrument;

    public Musician(String name, MusicalInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
        System.out.printf("Meet %s %s playing %s, which sounds like this: %s. \n", getClass().getSimpleName(), name, instrument.getName(), instrument.getSound());
    }


    public String getName() {
        return name;
    }

    public void sayHello() {
        System.out.println(name);
        System.out.println(instrument.getName());
    }

    public void engageMusician() {
        instrument.playSound();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Musician other = (Musician) obj;
        return Objects.equals(name, other.name) && Objects.equals(instrument.getName(), other.instrument.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, instrument);
    }
}

