package com.zoolatech.lecture3.tasks._1.musician;

import com.zoolatech.lecture3.tasks._1.musical_instruments.Guitar;

public class Guitarist extends Musician {
    public Guitarist(String name) {
        super(name, new Guitar());
    }
}
