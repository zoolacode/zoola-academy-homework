package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public class Musician {
    private String name;
    private MusicInstrument instrument;

    public Musician(String name, MusicInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public void playMusic() {
        System.out.println(name + " plays a " + instrument.makeSound());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Musician)) return false;
        Musician musician = (Musician) o;
        return Objects.equals(name, musician.name) && Objects.equals(instrument, musician.instrument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, instrument);
    }

    @Override
    public String toString() {
        return "Musician{" +
                "name='" + name + '\'' +
                ", instrument=" + instrument +
                '}';
    }
}
