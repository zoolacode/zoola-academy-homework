package com.zoolatech.lecture3.tasks._1;
/**
 * Design classes that represent an orchestra,
 * musicians and musical instruments (at least 3 different one).
 * Each instrument has a name and a method to print a unique sound
 * of the instrument. Each musician has a name and an associated
 * instrument which he plays. It should be possible to distinguish
 * two musicians. A musician should also have a method which should
 * print his/her name and the name of an instrument. Then it needs
 * to make the instrument sound. It should be possible to add/remove
 * musicians from/to the orchestra. When the add/remove action is
 * performed, the orchestra needs to print the action name + name
 * of the musician. The orchestra should also have a method which
 * commands all musicians to play the music. Inside of the main
 * method, create a couple of instances of all classes and play the music.
 */

import com.zoolatech.lecture3.tasks._1.musical_instrument.*;
import com.zoolatech.lecture3.tasks._1.musician.*;

public class Task1 {
    public static void main(String[] args) {
        // As far as each musician plays its own instrument, they are
        // automatically created for each musician. You can, though,
        // create separate instrument manually
        var vocalist = new Vocalist("Till Lindemann");
        var drummer = new Drummer("Christoph Schneider");
        var guitarist = new Guitarist("Richard Kruspe");
        var pianist = new Pianist("Christian Lorenz");

        vocalist.sayHello();

        var vocalist2 = new Vocalist("Till Lindemann");
        // check if equal (name&instrument)
        vocalist2.isEqual(vocalist);

        var drum = new Drum();
        drum.playSound();

        var orchestra = new Orchestra();

        orchestra.addToOrchestra(vocalist);
        orchestra.addToOrchestra(drummer);
        orchestra.addToOrchestra(guitarist);
        orchestra.addToOrchestra(pianist);

        orchestra.removeFromOrchestra(pianist);
        orchestra.addToOrchestra(pianist);

        orchestra.perform();
    }
}
