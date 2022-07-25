package com.zoolatech.lecture2.tasks._2;

import java.util.Locale;
import java.util.Scanner;

public class RobotController {
    private static Scanner scanner = new Scanner(System.in);
    private Robot robot;

    public void createRobot() {
        String widthS = "width",
                heightS = "height";
        System.out.println("Welcome to robot controller!!! \nLet`s set room for robot!");
        int width = initRoomParameter(widthS);
        int height = initRoomParameter(heightS);

        System.out.println("Do you want to set start location? (Y/N)");
        String answer = scanner.next();
        int x = 0, y = 0;
        if (!answer.isBlank() && "Y".equalsIgnoreCase(answer)) {
            x = initStartPoint(width, widthS);
            y = initStartPoint(height, heightS);
        }

        Direction direction = initStartDirection();
        this.robot = new Robot(width, height, x, y, direction);
        System.out.println("Initializing process is finished");
    }

    private int initRoomParameter(String name) {
        int side;
        do {
            System.out.println("Enter a " + name + ":");
            side = scanner.nextInt();
        } while (side <= 0);
        return side;
    }

    private int initStartPoint(int max, String name) {
        int x;
        do {
            System.out.println("Enter a " + name + " point:");
            x = scanner.nextInt();
            if (x > max)
                System.out.println("Point: '" + x + "' is outside the room");
        } while (x <= 0 || x >= max);
        return x;
    }

    private Direction initStartDirection() {
        System.out.println("Do you want to set start direction for robot? (Y/N)");
        String answer = scanner.next();
        if (!answer.isBlank() && "Y".equalsIgnoreCase(answer)) {
            System.out.println("Enter the direction (N/S/W/E):");
            String directionStr = scanner.next();
            return switch (directionStr.toUpperCase(Locale.ROOT)) {
                case "N" -> Direction.NORTH;
                case "S" -> Direction.SOUTH;
                case "W" -> Direction.WEST;
                case "E" -> Direction.SOUTH;
                default -> throw new IllegalArgumentException("direction is not exist");
            };
        }
        return Direction.SOUTH;
    }

    public void controlRobot() {
        boolean flag = true;
        showInstruction();
        while (flag) {
            System.out.println("Input operation:");
            String action = scanner.next();
            switch (action.toUpperCase(Locale.ROOT)) {
                case "M" -> {
                    System.out.println("Input the number of steps:");
                    robot.moveForward(scanner.nextInt());
                }
                case "O" -> robot.takeOneStep();
                case "L" -> robot.turnLeft();
                case "R" -> robot.turnRight();
                case "V" -> robot.showPosition();
                case "E" -> flag = false;
                case "I" -> showInstruction();
                default -> System.out.println("Incorrect operation \nTo view instruction press: 'I'");
            }
        }
    }

    private void showInstruction() {
        System.out.println("To take one step press: 'O' \n" +
                "To move forward press: 'M'\n" +
                "To turn left press: 'L'\n" +
                "To turn right press: 'R'\n" +
                "To view current position press: 'V'\n" +
                "To stop program press: 'E'\n" +
                "To view instruction press: 'I'");
    }
}
