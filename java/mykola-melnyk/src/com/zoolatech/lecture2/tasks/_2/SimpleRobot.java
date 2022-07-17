package com.zoolatech.lecture2.tasks._2;

//import java.util.Scanner;
enum Direction{
    LEFT,
    RIGHT
}
public class SimpleRobot {
    private int x;
    private int limit;
//    private boolean forwdir = true;
    private Direction dir = Direction.RIGHT;


    public SimpleRobot(int startPosition, int wall) {
        x = startPosition;
        limit = wall;
    }

    //private int newPosition =
    public void move(int steps) {
        if (dir == Direction.RIGHT) {
            if ((x + steps) < limit) {
                x += steps;
            } else {
                x = limit - 1;
            }
        } else {
            if ((x - steps) >= 0) {
                x -= steps;
            } else {
                x = 0;
            }
        }
    }

    public int getPosition() {
        return x;
    }
    public void printMap() {
        for (int i = 0; i < limit; i++) {
            if (i == x) {
                System.out.print("@");
            } else {
                System.out.print(".");
            }
        }
        System.out.println();
    }

    public void turn180() {
        if (dir == Direction.RIGHT) {
            dir = Direction.LEFT

        }
    }

}

class SimpleRobotDriver {
    public static void main(String[] args) {
        System.out.println("Hello World!");

//        int startPosition = 11;

        SimpleRobot robic = new SimpleRobot(0,10);
        robic.printMap();
        robic.move(1);
        robic.printMap();
        robic.move(5);
        robic.printMap();
        robic.turn180();
        robic.move(33);
        robic.printMap();
        robic.turn180();
        robic.move(3);
        robic.printMap();


    }
}
