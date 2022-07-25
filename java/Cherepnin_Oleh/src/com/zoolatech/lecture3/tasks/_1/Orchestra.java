package com.zoolatech.lecture3.tasks._1;

import java.util.Set;

public class Orchestra {
    private Set<Musician> musicians;

    public Orchestra(Set<Musician> musicians) {
        this.musicians = musicians;
    }

    public void addMusician(Musician musician) {
        if (musicians.add(musician)) {
            System.out.println(musician + " added to orchestra");
        }
    }

    public void removeMusician(Musician musician) {
        if (musicians.remove(musician)) {
            System.out.println(musician + " removed from orchestra");
        }
    }

    public void playMusic() {
        System.out.println("The orchestra starts to play:");
        musicians.forEach(Musician::playMusic);
    }
}
