package com.zoolatech.lecture3.tasks._1.musician;

import com.zoolatech.lecture3.tasks._1.musical_instrument.Piano;

public class Pianist extends Musician {
    public Pianist(String name) {
        super(name, new Piano());
    }
}
