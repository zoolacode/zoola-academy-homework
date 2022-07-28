package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        Vocals vocals = new Vocals("vocals", "vocals sound");
        Drum drum = new Drum("drum", "drum sound");
        Guitar guitar = new Guitar("guitar", "guitar sound");
        Piano piano = new Piano("piano", "piano sound");

//        Vocalist vocalist = new Vocalist("TillLindemann", vocals);
//        Drummer drummer = new Drummer("ChristophSchneider", drum);
//        Guitarist guitarist = new Guitarist("RichardKruspe", guitar);
//        Pianist pianist = new Pianist("ChristianLorenz", piano);

        ArrayList<Musician> orchestra = new ArrayList<>();
        orchestra.add(new Vocalist("TillLindemann", vocals));
        orchestra.add(new Drummer("ChristophSchneider", drum));
        orchestra.add(new Guitarist("RichardKruspe", guitar));
        orchestra.add(new Pianist("ChristianLorenz", piano));

        orchestra.remove()


    }
}
