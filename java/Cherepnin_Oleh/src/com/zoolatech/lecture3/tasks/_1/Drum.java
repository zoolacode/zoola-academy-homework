package com.zoolatech.lecture3.tasks._1;

public class Drum extends MusicInstrument {

    public Drum(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": bum-bum";
    }

    @Override
    public String toString() {
        return "Drum{ " + getName() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Drum)) return false;
        return super.equals(o);
    }

}
