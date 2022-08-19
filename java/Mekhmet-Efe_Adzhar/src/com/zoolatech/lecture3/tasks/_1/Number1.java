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
        Number1 number1 = new Number1();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Musicians> list = new ArrayList<>();
        Orchestra orchestra = new Orchestra(list);
        orchestra.addMusician(number1.chooseInstrument());

        System.out.println("Orchestra:");
        System.out.println("1. Musician Info.\n2. Add Musician\n3. Remove Musician\n4. Play!\n5. Exit");
        boolean exit = false;
        while (!exit) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    String orchestraList = orchestra.toString();
                    System.out.println(orchestraList);
                    System.out.print("Amount of musicians:");
                    orchestra.amountOfMusicians();
                }
                case 2 -> orchestra.addMusician(number1.chooseInstrument());
                case 3 -> {
                    System.out.println("Choose witch one is removed: Starting from 0 to N-1");
                    orchestra.removeMusician(scanner.nextInt());
                }
                case 4 -> orchestra.play();
                case 5 -> exit = true;
                default -> System.out.println("ERROR");
            }
        }
    }

    public Musicians chooseInstrument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Musician name:");
        Musicians musicians = new Musicians(scanner.next());
        System.out.print("Name is:");
        musicians.getName();
        System.out.println("What is his/her instrument?:");
        System.out.println("1. Piano\n2. Violin\n3. Guitar");

        switch (scanner.nextInt()) {
            case 1 -> {
                Piano piano = new Piano();
                System.out.print("Instrument is: " + piano.getName());
                musicians.setInstrument(piano);
            }
            case 2 -> {
                Violin violin = new Violin();
                System.out.print("Instrument is: " +  violin.getName());
                musicians.setInstrument(violin);
            }
            case 3 -> {
                Guitar guitar = new Guitar();
                System.out.print("Instrument is: " + guitar.getName());
                musicians.setInstrument(guitar);
            }
            default -> throw new IllegalStateException("Unexpected value: " + scanner.nextInt());
        }
        return musicians;
    }
}

record Orchestra(ArrayList<Musicians> list) {

    public void play() {
        for (Musicians musicians : list) {
            System.out.println(musicians.getSoundOfInstrument());
        }
    }

    public void addMusician(Musicians musicians) {
        this.list.add(musicians);
    }

    public void removeMusician(int integer) {
        var removedMusician = this.list.remove(integer);
        System.out.println("Removed" + removedMusician);
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
    private static int id = 0;
    private Instruments instrument;
    private final int incrementId = ++id;
    private final String name;

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

    public String getSoundOfInstrument() {
      return  instrument.getSound();
    }
}

interface Instruments {

    String getSound();

    String getName();
}

class Piano implements Instruments {
    @Override
    public String getSound() {
        return "PIN PIN PIN";
    }

    @Override
    public String getName() {
        return "Piano";
    }

    @Override
    public String toString() {
        return "His/Her instrument is " + getName() + ", " +
                "it makes sound: " + getSound();
    }
}

class Violin implements Instruments {
    @Override
    public String getSound() {
        return "VI VI VI";
    }

    @Override
    public String getName() {
        return "Violin";
    }

    @Override
    public String toString() {
        return "His/Her instrument is " + getName() + ", " +
                "it makes sound: " + getSound();
    }
}

class Guitar implements Instruments {
    @Override
    public String getSound() {
        return "DUSH DUSH DUSH";
    }

    @Override
    public String getName() {
        return "Guitar";
    }

    @Override
    public String toString() {
       return "His/Her instrument is " + getName() + ", " +
                "it makes sound: " + getSound();
    }
}