package com.zoolatech.lecture3.tasks._1;

import java.util.HashSet;

/**
 * Design classes that represent an orchestra, musicians and musical instruments (at least 3 different one).
 * Each instrument has a name and a method to print a unique sound of the instrument. Each musician has a name
 * and an associated instrument which he plays. It should be possible to distinguish two musicians. A musician
 * should also have a method which should print his/her name and the name of an instrument. Then it needs to make
 * the instrument sound. It should be possible to add/remove musicians from/to the orchestra. When the add/remove
 * action is performed, the orchestra needs to print the action name + name of the musician. The orchestra should
 * also have a method which commands all musicians to play the music. Inside of the main method, create a couple of
 * instances of all classes and play the music.
 */
public class TaskOne {

    public static void main(String[] args) {
        Orchestra orchestra = new Orchestra(new HashSet<>() {{
            add(new Musician("Jake", new Drum("yamaha drum")));
            add(new Musician("John", new Guitar("bass-guitar")));
            add(new Musician("Tanya", new Piano("electric piano")));
        }});

        orchestra.addMusician(new Musician("Ronald", new Guitar("rock-guitar")));
        orchestra.removeMusician(new Musician("John", new Guitar("bass-guitar")));
        orchestra.playMusic();
    }
}

