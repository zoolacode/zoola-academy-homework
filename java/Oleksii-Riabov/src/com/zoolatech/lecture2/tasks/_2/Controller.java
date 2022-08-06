package com.zoolatech.lecture2.tasks._2;

import java.util.Scanner;

public class Controller {
    Robot robot;

    public void creation() {
        System.out.println("To create Robot with default values enter \"1\"" +
                "\nTo create Robot with values initialization enter \"2\"");

        String condition = "false";
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int inputValue = scanner.nextInt();
                scanner.nextLine();
                if (inputValue == 1) {
                    robot = new Robot();
                    break;
                } else if (inputValue == 2) {
                    System.out.println("Enter Room's width as integer value.");
                    int roomWidth = getValue();
                    roomWidth--;

                    System.out.println("Enter Room's height as integer value.");
                    int roomHeight = getValue();
                    roomHeight--;

                    System.out.println("Enter Robot's default direction as String value (south, west, north or east).");
                    String direction = "SOUTH";

                    do {
                        String line = scanner.nextLine().toUpperCase();

                        switch (line) {
                            case "NORTH" -> {
                                direction = "NORTH";
                                condition = "exit";
                            }
                            case "SOUTH" -> {
                                direction = "SOUTH";
                                condition = "exit";
                            }
                            case "EAST" -> {
                                direction = "EAST";
                                condition = "exit";
                            }
                            case "WEST" -> {
                                direction = "WEST";
                                condition = "exit";
                            }
                            default -> System.out.println("Define correct direction.");
                        }
                    } while (!"exit".equals(condition));

                    System.out.println("Enter Robot's starting width as integer value.");
                    int robotWidth = getValue();

                    System.out.println("Enter Robot's starting height as integer value.");
                    int robotHeight = getValue();

                    robot = new Robot(roomWidth, roomHeight, direction, robotWidth, robotHeight);

                } else {
                    System.out.println("Enter \"1\" or \"2\"");
                }
            } else {
                System.out.println("Enter integer value");
            }
        } while(!"exit".equals(condition));
        System.out.println(robot);
    }

    public static int getValue() {
        String condition = "false";
        int returnValue = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                returnValue = scanner.nextInt();
                condition = "exit";
            } else {
                System.out.println("Enter integer value");
            }
        } while(!"exit".equals(condition));
        return returnValue;
    }

    public void makeActions() {
        Scanner input = new Scanner(System.in);
        String condition = "false";

        do {
            getInstructions();
            System.out.println("Enter action");

            String line = input.nextLine().toUpperCase();
            switch (line) {
                case "M" -> {
                    System.out.println("Enter number of tiles to move as integer value.");
                    robot.move(getValue());
                    System.out.println(this);
                    System.out.println();
                }
                case "L" -> {
                    robot.turnLeft();
                    System.out.println(this);
                    System.out.println();
                }
                case "R" -> {
                    robot.turnRight();
                    System.out.println(this);
                    System.out.println();
                }
                case "C" -> {
                    robot.getCoordinates();
                    System.out.println();
                }
                case "D" -> {
                    System.out.println("Robot's direction is: " + robot.getDirection());
                    System.out.println();
                }
                case "I" -> getInstructions();
                case "EXIT" -> {
                    System.out.println("Program ends");
                    condition = "exit";
                }
                default -> System.out.println("Please enter valid value\n");
            }
        } while(!"exit".equals(condition));
    }

    public void getInstructions() {
        System.out.println("""
                To move Robot enter "m"
                To turn Robot left enter "l"
                To turn Robot right enter "r"
                To get Robot's coordinates enter "c"
                To get Robot's direction enter "d"
                To get instructions enter "i"
                To end program enter "exit"
                """);
    }

    @Override
    public String toString() {
        return "Robot's direction is: " + robot.getDirection() + "\nRoom's size is:" +
                " W-H(0-" + robot.getRoom().width() + ",0-" + robot.getRoom().height() + ")," +
                " \nRobot's coordinates are: W-H(" + robot.getWidth() + "," + robot.getHeight() + ").";
    }
}
