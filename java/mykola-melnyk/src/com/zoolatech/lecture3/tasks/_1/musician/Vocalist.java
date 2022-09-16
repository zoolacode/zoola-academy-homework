package com.zoolatech.lecture3.tasks._1.musician;

import com.zoolatech.lecture3.tasks._1.musical_instrument.Vocals;

public class Vocalist extends Musician {
    public Vocalist(String name) {
        super(name, new Vocals());
    }
}
