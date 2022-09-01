package com.zoolatech.lecture3.tasks._1;

public class Guitar extends MusicInstrument {

    public Guitar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": brin-brin");
    }

    @Override
    public String toString() {
        return "Guitar{ " + getName() + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Guitar)) return false;
        return super.equals(o);
    }
}
