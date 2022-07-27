package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

abstract public class Musician {
    String name;

    Musician(String name) {
        this.name = name;
    }

    abstract void playInstrument();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return Objects.equals(name, musician.name);
    }

    void printInfo() {
        System.out.println("Name: " + name);
    }
}

class Guitarist extends Musician {
    Guitarist(String name) {
        super(name);
    }

    @Override
    void playInstrument() {
        guitar.playSound();
    }

    private Guitar guitar = new Guitar();

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.guitar.instrumentName);
        guitar.playSound();
    }
}

class Pianist extends Musician {
    Pianist(String name) {
        super(name);
    }

    @Override
    void playInstrument() {
        piano.playSound();
    }

    private Piano piano = new Piano();

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.piano.instrumentName);
        piano.playSound();
    }
}

class Violinist extends Musician {
    Violinist(String name) {
        super(name);
    }

    @Override
    void playInstrument() {
        violin.playSound();
    }

    private Violin violin = new Violin();

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.violin.instrumentName);
        violin.playSound();
    }
}