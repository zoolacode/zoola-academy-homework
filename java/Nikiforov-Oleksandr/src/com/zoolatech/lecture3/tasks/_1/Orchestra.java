package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {
    private final ArrayList<Musician> musicians = new ArrayList<>();
    private final String orchestraName;

    public Orchestra(String orchestraName) {
        this.orchestraName = orchestraName;
    }

    public void addMusician(Musician musician) {
        musicians.add(musician);
        System.out.println(musician + " joined " + orchestraName);
    }

    public void removeMusician(Musician musician) {
        musicians.remove(musician);
        System.out.println(musician + " left " + orchestraName);
    }

    public void playAll() {
        System.out.println(orchestraName + " plays!");
        for (Musician musician : musicians) {
            musician.getInstrument().play();
        }
    }
}
