package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {
    private ArrayList<Musician> listOfMusicians = new ArrayList<>();

    public void add(Musician musician) {
        listOfMusicians.add(musician);
        System.out.println(musician + " joined first group");
    }

    public void remove(Musician musician) {
        listOfMusicians.remove(musician);
        System.out.println(musician + " left first group");
    }

    public void playAll() {
        for (Musician m : listOfMusicians) {
            m.playMusic();
        }
    }
}
