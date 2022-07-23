package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {
    ArrayList<Musicians> orchestra = new ArrayList<>();

    void add(Musicians musician) {
        orchestra.add(musician);
        System.out.println(musician.name + " added to orchestra");
    }

    void remove(Musicians musician) {
        orchestra.remove(musician);
        System.out.println(musician.name + " removed from orchestra");
    }

    void playMusic() {
        for (Musicians msc : orchestra) {
            msc.playInstrument();
        }
    }
}
