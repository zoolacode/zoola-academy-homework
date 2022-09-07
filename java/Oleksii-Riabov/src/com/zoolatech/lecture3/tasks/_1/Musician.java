package com.zoolatech.lecture3.tasks._1;

public class Musician {
    private final String name;
    private final Instrument instrument;

    public Musician(String name, Instrument instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public String getName() {
        return name;
    }

    public void printNameAndInstrument() {
        System.out.println("My name is: " + name + ", I play on: " + instrument.getName());
    }

    public void makeInstrumentSound() {
        instrument.sound();
    }
}
