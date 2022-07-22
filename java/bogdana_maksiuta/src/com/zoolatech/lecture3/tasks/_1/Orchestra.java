package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Orchestra {
    ArrayList<Musicians> listOfMusicians = new ArrayList<>();

    public void add(Musicians musicians) {
        listOfMusicians.add(musicians);
        System.out.println(musicians + " joined first group");
    }

    public void remove(Musicians musicians) {
        listOfMusicians.remove(musicians);
        System.out.println(musicians + " left first group");
    }

    public void playAll() {
        for (Musicians m : listOfMusicians) {
            m.instrument.play();
        }
    }
}
