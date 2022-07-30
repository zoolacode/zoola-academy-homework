package com.zoolatech.lecture3.tasks._1;

import com.zoolatech.lecture3.tasks._1.musician.Musician;

import java.util.ArrayList;

public class Orchestra {
    private ArrayList<Musician> orchestra = new ArrayList<>();

    public void addToOrchestra(Musician musician) {
       orchestra.add(musician);
       System.out.printf("Adding %s to orchestra. \n", musician.getName());
    }

    public void removeFromOrchestra(Musician musician) {
        orchestra.remove(musician);
        System.out.printf("Removing %s from orchestra. \n", musician.getName());
    }

    public void perform() {
        for (var e : orchestra) {
            e.engageMusician();
        }
    }
}
