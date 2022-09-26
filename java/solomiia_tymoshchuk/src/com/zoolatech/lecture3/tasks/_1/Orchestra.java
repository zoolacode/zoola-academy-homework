package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {

    ArrayList<Musician> musiciansList = new ArrayList<>();

    void addMusicians(Musician musician) {
        musiciansList.add(musician);
        System.out.println(musician.getMusicianName() + " added");
    }

    void removeMusicians(Musician musician) {
        musiciansList.remove(musician);
        System.out.println(musician.getMusicianName() + " removed");
    }

    void playMusic() {
        for (var object : musiciansList) {
            object.playSound();
        }
    }

    public static void main(String[] args) {
        MusicalInstrument musicalInstrument = new MusicalInstrument("piano", "special sound");
        MusicalInstrument guitar = new MusicalInstrument("guitar", "guitarSound");
        Musician musician = new Musician("Ivan", musicalInstrument);
        Musician guitarist = new Musician("Petro", guitar);
        Orchestra orchestra = new Orchestra();
        orchestra.addMusicians(musician);
        orchestra.addMusicians(guitarist);
        orchestra.playMusic();
    }
}
