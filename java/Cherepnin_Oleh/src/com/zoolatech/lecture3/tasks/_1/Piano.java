package com.zoolatech.lecture3.tasks._1;

public class Piano extends MusicInstrument {

    public Piano(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": na-na-na";
    }

    @Override
    public String toString() {
        return "Piano{ " + getName() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Piano)) return false;
        return super.equals(o);
    }
}
