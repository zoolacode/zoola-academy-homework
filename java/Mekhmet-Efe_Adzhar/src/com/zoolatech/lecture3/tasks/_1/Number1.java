package com.zoolatech.lecture3.tasks._1;

import java.util.ArrayList;
import java.util.Scanner;

/*
Design classes that represent an orchestra, musicians and musical instruments (at least 3 different one).
Each instrument has a name and a method to print a unique sound of the instrument.
Each musician has a name and an associated instrument which he plays.
It should be possible to distinguish two musicians.
A musician should also have a method which should print his/her name and the name of an instrument.
Then it needs to make the instrument sound. It should be possible to add/remove musicians from/to the orchestra.
When the add/remove action is performed, the orchestra needs to print the action name + name of the musician.
The orchestra should also have a method which commands all musicians to play the music.
Inside of the main method, create a couple of instances of all classes and play the music.
 */

public class Number1 {

    public static void main(String[] args) {
        boolean exit = false;
        String string;
        Number1 number1 = new Number1();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Musicians> list = new ArrayList<>();
        number1.chooseInstrument(list);
        Orchestra orchestra = new Orchestra(list);

        System.out.println("Orchestra:");
        System.out.println("1. Musician Info.\n2. Add Musician\n3. Remove Musician\n4. Play!\n5. Exit");
        while (!exit) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    string = orchestra.toString();
                    System.out.println(string);
                    System.out.print("Amount of musicians:");
                    orchestra.amountOfMusicians();
                }
                case 2 -> {
                    number1.chooseInstrument(list);
                }
                case 3 -> {
                    System.out.println("Choose witch one is removed: Starting from 0 to N-1");
                    orchestra.removeMusician(scanner.nextInt());
                }
                case 4 -> {
                    orchestra.play();
                }
                case 5 -> exit = true;
                default -> System.out.println("ERROR");
            }
        }
    }

    public void chooseInstrument(ArrayList<Musicians> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Musician name:");
        Musicians musicians = new Musicians(scanner.next());
        System.out.print("Name is:");
        musicians.getName();
        Orchestra orchestra = new Orchestra(list);
        System.out.println("What is his/her instrument?:");
        System.out.println("1. Piano\n2. Violin\n3. Guitar");

        switch (scanner.nextInt()) {
            case 1 -> {
                Instruments piano = new Piano("PIN PIN PIN", "Piano");
                System.out.print("Instrument is: ");
                piano.getName();
                musicians.setInstrument(piano);
                orchestra.addMusician(musicians);
            }
            case 2 -> {
                Instruments violin = new Violin("VI VI VI", "Violin");
                System.out.print("Instrument is: ");
                violin.getName();
                musicians.setInstrument(violin);
                orchestra.addMusician(musicians);
            }
            case 3 -> {
                Instruments guitar = new Guitar("DSUCH DSUCH DSUCH", "Violin");
                System.out.print("Instrument is: ");
                guitar.getName();
                musicians.setInstrument(guitar);
                orchestra.addMusician(musicians);
            }
            default -> throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
        }
    }
}

class Orchestra {

    private ArrayList<Musicians> list;

    public Orchestra(ArrayList<Musicians> list) {
        this.list = list;
    }

    public void play() {
        for (Musicians musicians : list) {
            musicians.instrument.getSound();
        }
    }

    public void addMusician(Musicians musicians) {
        this.list.add(musicians);
    }

    public void removeMusician(int integer) {
        var variable = this.list.remove(integer);
        System.out.println("Removed" + variable);
    }

    public void amountOfMusicians() {
        System.out.println(list.size());
    }

    @Override
    public String toString() {
        return "Orchestra{" + "\n" + list +
                '}';
    }
}

class Musicians {

    Instruments instrument;
    private static int id = 0;
    private int incrementId = ++id;

    private String name;

    @Override
    public String toString() {
        return "Musician: " + "[id" + " " + incrementId + ", name of a musician = " + name + ']' + "\n" +
                '[' + instrument + ']' + "\n";
    }

    public Musicians(String name) {
        this.name = name;
    }

    public void getName() {
        System.out.println(name);
    }

    public void setInstrument(Instruments instrument) {
        this.instrument = instrument;
    }

    public void getInstrument() {
        System.out.println(instrument);
    }

    public static int getId() {
        return id;
    }
}

class Instruments {
    private final String sound;
    private final String name;

    public Instruments(String sound, String name) {
        this.sound = sound;
        this.name = name;
    }

    public void getName() {
        System.out.println(name);
    }

    public void getSound() {
        System.out.println(sound);
    }

    @Override
    public String toString() {
        return "His/Her instrument is " + name + ", " +
                "it makes sound: " + sound;
    }
}

class Piano extends Instruments {

    public Piano(String sound, String name) {
        super(sound, name);
    }
}

class Violin extends Instruments {

    public Violin(String sound, String name) {
        super(sound, name);
    }
}

class Guitar extends Instruments {

    public Guitar(String sound, String name) {
        super(sound, name);
    }
}