package com.zoolatech.lecture3.tasks._1;

import java.util.Objects;

abstract public class Musicians {
    String name;

    Musicians(String name) {
        this.name = name;
    }

    abstract void playInstrument();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musicians musician = (Musicians) o;
        return Objects.equals(name, musician.name);
    }

    void printInfo() {
        System.out.println("Name: " + name);
    }
}

class Guitarist extends Musicians {
    Guitarist(String name) {
        super(name);
    }

    @Override
    void playInstrument() {
        guitar.playSound();
    }

    Guitar guitar = new Guitar();

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.guitar.instrumentName);
        guitar.playSound();
    }
}

class Pianist extends Musicians {
    Pianist(String name) {
        super(name);
    }

    @Override
    void playInstrument() {
        piano.playSound();
    }

    Piano piano = new Piano();

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.piano.instrumentName);
        piano.playSound();
    }
}

class Violinist extends Musicians {
    Violinist(String name) {
        super(name);
    }

    @Override
    void playInstrument() {
        violin.playSound();
    }

    Violin violin = new Violin();

    @Override
    void printInfo() {
        super.printInfo();
        System.out.println(this.violin.instrumentName);
        violin.playSound();
    }
}