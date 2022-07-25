package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public abstract class MusicInstrument {
    private String name;

    public MusicInstrument(String name) {
        this.name = name;
    }

    abstract String makeSound();

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicInstrument)) return false;
        MusicInstrument that = (MusicInstrument) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
