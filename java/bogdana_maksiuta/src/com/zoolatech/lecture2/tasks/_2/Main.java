package com.zoolatech.lecture2.tasks._2;

/**
 * Define a class that represents a robot, which moves in a room of a width W and a height of H.
 * The class should provide methods to move a robot forward by either 1 or N tiles and
 * turn it either left or right by 90 degrees from the current direction.
 * The class should also provide methods to get the robot's current location and direction.
 * The north-west corner of a room is represented by coordinates (0,0); north-east - (W-1, 0);
 * south-east - (W-1, H-1); south-west - (0, H-1).
 * By default, a robot should be placed in the north-west corner facing south direction.
 * However, it should be also possible to give any coordinates and direction as the initial robot location.
 * Robot must not be able to get outside of a room - in such case the robot should move as much as possible
 * to the room border, print a warning message and stop. All next moves in the same direction should be prevented.
 */

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Robot robot = new Robot();
        start(robot);
        menu(robot);
    }

    public static void start(Robot robot) {
        System.out.println("Welcome! \nEnter width of the room: ");
        robot.setWidthRoom(scanner.nextInt());
        System.out.println("Enter Height of the room: ");
        robot.setHeightRoom(scanner.nextInt());
        int startChoice;
        do {
            System.out.println("Press '1' to Start from charging station " +
                    "\nPress '2' to Start from custom coordinates");
            startChoice = scanner.nextInt();
            if (startChoice == 1) {
                positionByDefault(robot);
                robot.currentLocation();
                robot.currentDirection();
            } else if (startChoice == 2) {
                customerCoordinates(robot);
                robot.currentLocation();
                robot.currentDirection();
            } else {
                System.out.println("I don't understand you. Try again");
            }
        } while (startChoice < 1 || startChoice > 2);
    }

    public static void positionByDefault(Robot robot) {
        robot.setH(0);
        robot.setW(0);
        robot.southDirection();
    }

    public static void customerCoordinates(Robot robot) {
        System.out.println("Your room-size is: " + robot.getHeightRoom() + " x " +
                robot.getWidthRoom() + ". Where I need to start?");
        System.out.println("Height (from 0 to " + (robot.getHeightRoom() - 1) + "): ");
        robot.setH(scanner.nextInt());
        if (robot.getH() >= 0 && robot.getH() <= robot.getHeightRoom() - 1) {
            System.out.println("Weight (from 0 to " + (robot.getWidthRoom() - 1) + "): ");
            robot.setW(scanner.nextInt());
            if (robot.getW() >= 0 && robot.getW() <= robot.getWidthRoom() - 1) {
                System.out.println("Choose the directory : \n'1' - south \n'2' - east \n'3' - north \n'4' - west");
                int choiceDirection = scanner.nextInt();
                switch (choiceDirection) {
                    case 1 -> robot.southDirection();
                    case 2 -> robot.eastDirection();
                    case 3 -> robot.northDirection();
                    case 4 -> robot.westDirection();
                    default -> invalidValueInPosition(robot);
                }
            }
        } else {
            invalidValueInPosition(robot);
        }
    }

    public static void invalidValueInPosition(Robot robot) {
        System.out.println("Invalid value. Do you want to try again? \n'1' - yes '2' - no");
        int tryAgain = scanner.nextInt();
        switch (tryAgain) {
            case 1 -> customerCoordinates(robot);
            case 2 -> positionByDefault(robot);
            case 3 -> {
                System.out.println("You need to try harder. I'll start from my charging station");
                positionByDefault(robot);
            }
        }
    }

    public static void menu(Robot robot) {
        boolean working = true;
        while (working) {
            System.out.println("""
                    Moving on next tile - Press '1'
                    Move on N tiles - Press '2'
                    Turn the other way - Press '3'
                    Display the current position - Press '4'
                    Stop - Press '5'
                    """);

            int choice = scanner.nextInt();
            if (choice == 1) {
                robot.move();
            } else if (choice == 2) {
                System.out.println("How much tiles need clean?");
                int tiles = scanner.nextInt();
                robot.move(tiles);
            } else if (choice == 3) {
                System.out.println("Turn RIGHT - press '1' \nTurn LEFT - press '2'");
                int chooseSide = scanner.nextInt();
                switch (chooseSide) {
                    case 1 -> robot.turnRight();
                    case 2 -> robot.turnLeft();
                    default -> System.out.println("Try again");
                }
            } else if (choice == 4) {
                robot.currentDirection();
                robot.currentLocation();
            } else if (choice == 5) {
                System.out.println("Bye");
                working = false;// I don't know how to stop it
            } else {
                System.out.println("Invalid number. Try again");
            }
        }
    }
}