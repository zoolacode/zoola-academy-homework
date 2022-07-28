package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

public class Musician {
    private String name;
    private MusicalInstrument instrument;
    public Musician (String name, MusicalInstrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Musician other = (Musician) obj;
        return Objects.equals(name, other.name)
               && Objects.equals(instrument, other.instrument);
    }

    public void engageMusician() {
        System.out.println(this.name);
        System.out.println(this.instrument);
        System.out.println(this.instrument.playSound());
    }
}

class Vocalist extends Musician {
    public Vocalist(String name, MusicalInstrument instrument) {
        super(name, instrument);
    }
}

class Drummer extends Musician {
    public Drummer(String name, MusicalInstrument instrument) {
        super(name, instrument);
    }
}

class Guitarist extends Musician {
    public Guitarist(String name, MusicalInstrument instrument) {
        super(name, instrument);
    }
}

class Pianist extends Musician {
    public Pianist(String name, MusicalInstrument instrument) {
        super(name, instrument);
    }
}
