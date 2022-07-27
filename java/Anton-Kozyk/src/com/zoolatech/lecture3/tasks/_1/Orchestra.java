package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {
    private ArrayList<Musician> orchestra = new ArrayList<>();

    void add(Musician musician) {
        orchestra.add(musician);
        System.out.println(musician.name + " added to orchestra");
    }

    void remove(Musician musician) {
        orchestra.remove(musician);
        System.out.println(musician.name + " removed from orchestra");
    }

    void playMusic() {
        for (Musician msc : orchestra) {
            msc.playInstrument();
        }
    }
}
