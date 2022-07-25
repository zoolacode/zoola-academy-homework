package com.zoolatech.lecture3.tasks._1;

/**
 * Design classes that represent an orchestra, musicians and musical instruments (at least 3 different one).
 * Each instrument has a name and a method to print a unique sound of the instrument. Each musician has a name
 * and an associated instrument which he plays. It should be possible to distinguish two musicians.
 * A musician should also have a method which should print his/her name and the name of an instrument.
 * Then it needs to make the instrument sound. It should be possible to add/remove musicians from/to the orchestra.
 * When the add/remove action is performed, the orchestra needs to print the action name + name of the musician.
 * The orchestra should also have a method which commands all musicians to play the music. Inside of the main method,
 * create a couple of instances of all classes and play the music.
 */

public class Task1 {
    public static void main(String[] args) {
        Piano piano = new Piano("tra-la-la-la-la la-la-la", "Piano");
        Cello cello = new Cello("vi-vi-vi-vi la-vi-vi-vi", "Cello");
        Violin violin = new Violin("la-vi la-vi la-vi", "Violin");

        Musician pianist = new Musician("Adam", piano);
        pianist.OutputMusician();
        Musician violonist = new Musician("Eva", violin);
        violonist.OutputMusician();
        Musician cellist = new Musician("Alex", cello);
        cellist.OutputMusician();

        System.out.println();
        System.out.println("Are pianist and violonist the same? " + pianist.equals(violonist) + '\n');

        Orchestra orchestra = new Orchestra("string orchestra");
        orchestra.addMusician(pianist);
        orchestra.addMusician(violonist);
        orchestra.addMusician(cellist);
        System.out.println();
        orchestra.playAll();
        System.out.println();
        orchestra.removeMusician(pianist);
        orchestra.playAll();


    }
}
