package com.zoolatech.lecture3.tasks._1.musician;

import com.zoolatech.lecture3.tasks._1.musical_instruments.Drum;

public class Drummer extends Musician {
    public Drummer(String name) {
        super(name, new Drum());
    }
}
