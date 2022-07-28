package com.zoolatech.lecture3.tasks._1;

/**
 * Design classes that represent an orchestra, musicians and musical instruments (at least 3 different one).
 * Each instrument has a name and a method to print a unique sound of the instrument.
 * Each musician has a name and an associated instrument which he plays.
 * It should be possible to distinguish two musicians.
 * A musician should also have a method which should print his/her name and the name of an instrument.
 * Then it needs to make the instrument sound. It should be possible to add/remove musicians from/to the orchestra.
 * When the add/remove action is performed, the orchestra needs to print the action name + name of the musician.
 * The orchestra should also have a method which commands all musicians to play the music.
 * Inside of the main method, create a couple of instances of all classes and play the music.
 */
public class Main {
    public static void main(String[] args) {
        MusicalInstrument guitar = new MusicalInstrument("Guitar", "strum strum");
        MusicalInstrument trumpet = new MusicalInstrument("Trumpet", "pah-pa-rah");
        MusicalInstrument drum = new MusicalInstrument("Drum", "boom-bang, bang");

        Musician guitarist = new Musician("Alan", guitar);
        Musician trumpeter = new Musician("Mike", trumpet);
        Musician drummer = new Musician("Peter", drum);

        System.out.println("The guitarist and the drummer are the same person? " + guitarist.equals(drummer));
        guitarist.getNameAndInstrument(guitarist);
        trumpeter.getNameAndInstrument(trumpeter);
        drummer.getNameAndInstrument(drummer);


        Orchestra firstOrchestra = new Orchestra();
        firstOrchestra.add(guitarist);
        firstOrchestra.add(trumpeter);
        firstOrchestra.add(drummer);

        firstOrchestra.playAll();

        firstOrchestra.remove(trumpeter);
        firstOrchestra.playAll();
    }
}

