package com.zoolatech.lecture2.tasks._2;

import java.util.Scanner;

/**
 * Define a class that represents a robot, which moves in a room of a width W and a height of H.
 * The class should provide methods to move a robot forward by either 1 or N tiles and turn it either
 * left or right by 90 degrees from the current direction. The class should also provide methods to get the robot's current location and direction.
 * The north-west corner of a room is represented by coordinates (0,0); north-east - (W-1, 0); south-east - (W-1, H-1); south-west - (0, H-1).
 * By default, a robot should be placed in the north-west corner facing south direction. However, it should be also possible to give any coordinates
 * and direction as the initial robot location. Robot must not be able to get outside of a room - in such case the robot should move as much as possible
 * to the room border, print a warning message and stop. All next moves in the same direction should be prevented.
 */


public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input max width of the room: ");
        int maxw = sc.nextInt();
        System.out.println("Input max height of the room: ");
        int maxh = sc.nextInt();
        robotWork(maxw, maxh);
    }


    public static void robotWork(int maxWidth, int maxHeight) {
        Scanner sc = new Scanner(System.in);
        System.out.println("DO you want to enter the starting coordinates manually print 1, no - 2: ");
        int choiceInput = sc.nextInt();
        Robot robot = new Robot(maxWidth, maxHeight);
        if (choiceInput == 1) {
            System.out.println("Input w:");
            int width = sc.nextInt();
            System.out.println("Input h:");
            int height = sc.nextInt();
            robot.setHeight(height);
            robot.setWidth(width);
        }
        System.out.println("\nProgram started!");
        int inputer;
        while (true) {
            System.out.println("Input 1 to move; \nInput 2 to change direction; \nInput 3 to output current direction and coordinates;\nInput 4 to move on 1 tile;\nInput 0 to stop program:");
            inputer = sc.nextInt();
            switch (inputer) {
                case 1 -> {
                    System.out.println("Input step: ");
                    robot.move(sc.nextInt());
                    robot.getCoordinates();
                }
                case 2 -> {
                    System.out.println("Input L to move left, input R to move right:");
                    robot.changeDirection(sc.next().charAt(0));
                    robot.getDirection();
                }
                case 3 -> {
                    robot.getCoordinates();
                    robot.getDirection();
                }
                case 4 -> {
                    robot.moveOnTile();
                    robot.getCoordinates();
                }
                case 0 -> {
                    System.out.println("Bue!");
                    return;
                }
                default -> System.out.println("Input error");
            }
            System.out.println();
        }
    }
}
