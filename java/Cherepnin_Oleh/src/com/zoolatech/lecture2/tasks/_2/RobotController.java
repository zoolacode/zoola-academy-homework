package com.zoolatech.lecture2.tasks._2;

import java.util.Locale;
import java.util.Scanner;

public class RobotController {
    private static Scanner scanner = new Scanner(System.in);
    private Robot robot;

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
        System.out.println("To move forward press: 'M'\n" +
                "To turn left press: 'L'\n" +
                "To turn right press: 'R'\n" +
                "To view current position press: 'V'\n" +
                "To stop program press: 'E'\n" +
                "To view instruction press: 'I'");
    }

    public void createRobot() {
        String widthS = "width",
                heightS = "height";
        Direction direction;

        System.out.println("Welcome to robot controller!!! \nLet`s set room for robot!");
        int width = initRoomParameter(widthS);
        int height = initRoomParameter(heightS);
        String answer = askQuestion(1);

        if (answer.equalsIgnoreCase("Y")) {
            int x = setStartPoint(width, widthS);
            int y = setStartPoint(height, heightS);
            answer = askQuestion(2);

            if (answer.equalsIgnoreCase("Y")) {
                direction = setDirection();
                this.robot = new Robot(width, height, x, y, direction);
            } else this.robot = new Robot(width, height, x, y);
        } else {
            answer = askQuestion(2);

            if (answer.equalsIgnoreCase("Y")) {
                direction = setDirection();
                this.robot = new Robot(width, height, direction);
            } else this.robot = new Robot(width, height);
        }
        System.out.println("Initializing process is finished");
    }

    private String askQuestion(int questionNumber) {
        return switch (questionNumber) {
            case 1 -> {
                System.out.println("Do you want to set start location? (Y/N)");
                yield scanner.next();
            }
            case 2 -> {
                System.out.println("Do you want to set start direction for robot? (Y/N)");
                yield scanner.next();
            }
            default -> null;
        };
    }

    private int initRoomParameter(String name) {
        int side;
        do {
            System.out.println("Enter a " + name + ":");
            side = scanner.nextInt();
        } while (side <= 0);
        return side;
    }

    private int setStartPoint(int max, String name) {
        int x;
        do {
            System.out.println("Enter a " + name + " point:");
            x = scanner.nextInt();
            if (x > max)
                System.out.println("Point: '" + x + "' is outside the room");
        } while (x <= 0 || x >= max);
        return x;
    }

    private Direction setDirection() {
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

}
