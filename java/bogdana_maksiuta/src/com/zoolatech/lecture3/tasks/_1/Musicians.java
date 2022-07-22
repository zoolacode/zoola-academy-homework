package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public class Musicians {
    private String name;
    MusicalInstrument instrument;

    public Musicians(String name, MusicalInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public void getNameAndInstrument(Musicians musicians) {
        System.out.println(musicians);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musicians musicians = (Musicians) o;
        return Objects.equals(name, musicians.name) && Objects.equals(instrument, musicians.instrument);
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

