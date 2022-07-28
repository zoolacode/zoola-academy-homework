package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {
    ArrayList<Musician> musicians = new ArrayList<>();

    public void add(Musician musician) {
        musicians.add(musician);
        System.out.println("Add " + musician.getName());
    }

    public void remove(Musician musician) {
        musicians.remove(musician);
        System.out.println("Remove " + musician.getName());
    }

    public void play() {
        musicians.forEach(Musician::printNameAndInstrument);
        System.out.println();
        musicians.forEach(Musician::makeInstrumentSound);
    }
}
