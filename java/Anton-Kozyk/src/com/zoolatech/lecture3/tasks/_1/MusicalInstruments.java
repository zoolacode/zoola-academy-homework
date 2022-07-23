package com.zoolatech.lecture3.tasks._1;

abstract public class MusicalInstruments {
    String instrumentName;
    abstract void playSound();
}

class Guitar extends MusicalInstruments {
    Guitar() {
        instrumentName = "Guitar";
    }

    @Override
    void playSound() {
        System.out.println("*guitar sounds*");
    }
}

class Piano extends MusicalInstruments {
    Piano() {
        instrumentName = "Piano";
    }

    @Override
    void playSound() {
        System.out.println("*piano sounds*");
    }
}

class Violin extends MusicalInstruments {
    Violin() {
        instrumentName = "Violin";
    }

    @Override
    void playSound() {
        System.out.println("*violin sounds*");
    }
}

