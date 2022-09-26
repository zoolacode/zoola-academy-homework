package com.zoolatech.lecture3.tasks._1;

public class Musician {
    String musicianName;

    public String getMusicianName() {
        return musicianName;
    }

    private MusicalInstrument musicalInstrument;

    public Musician(String musicianName, MusicalInstrument musicalInstrument) {
        this.musicianName = musicianName;
        this.musicalInstrument = musicalInstrument;
    }

    void musicianDetails() {
        System.out.println("Name of musician" + musicianName + "Name of instrument" + musicalInstrument.getInstrumentName());
    }

    void playSound() {
        musicalInstrument.playUniqSound();
    }

}
