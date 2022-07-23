package com.zoolatech.lecture3.tasks._1;

/**
 * Design classes that represent an orchestra, musicians and musical instruments (at least 3 different one).
 * Each instrument has a name and a method to print a unique sound of the instrument. Each musician has a
 * name and an associated instrument which he plays. It should be possible to distinguish two musicians.
 * A musician should also have a method which should print his/her name and the name of an instrument.
 * Then it needs to make the instrument sound. It should be possible to add/remove musicians from/to the
 * orchestra. When the add/remove action is performed, the orchestra needs to print the action name + name
 * of the musician. The orchestra should also have a method which commands all musicians to play the music.
 * Inside of the main method, create a couple of instances of all classes and play the music.
 */

public class Task1 {
    public static void main(String[] args) {
        Violinist violinist = new Violinist("Jack Black");
        Guitarist guitarist1 = new Guitarist("Josh Bush");
        Guitarist guitarist2 = new Guitarist("Josh Washington");
        Pianist pianist = new Pianist("Sam Winchester");
        Orchestra orchestra = new Orchestra();

        orchestra.add(violinist);
        orchestra.add(guitarist1);
        orchestra.add(guitarist2);
        orchestra.add(pianist);
        orchestra.remove(guitarist1);
        System.out.println();

        orchestra.playMusic();
        System.out.println();

        pianist.printInfo();
        System.out.println();

        System.out.println(guitarist1.equals(guitarist2));
    }
}

