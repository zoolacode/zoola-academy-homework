package com.zoolatech.lecture2.tasks._2;

import java.util.Scanner;

public class Controller {
    Robot robot;

    public void create() {
        System.out.println("To create Robot with default values enter \"1\"" +
                "\nTo create Robot with values initialization enter \"2\"");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            int inputValue;
            if (scanner.hasNextInt()) {
                inputValue = scanner.nextInt();
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
                    String direction;
                    outer:
                    while (true) {
                        Scanner input = new Scanner(System.in);
                        String line = input.nextLine().toUpperCase();

                        switch (line) {
                            case "NORTH" -> {
                                direction = "NORTH";
                                break outer;
                            }
                            case "SOUTH" -> {
                                direction = "SOUTH";
                                break outer;
                            }
                            case "EAST" -> {
                                direction = "EAST";
                                break outer;
                            }
                            case "WEST" -> {
                                direction = "WEST";
                                break outer;
                            }
                            default -> {
                                System.out.println("Define correct direction.");
                                continue outer;
                            }
                        }
                    }

                    System.out.println("Enter Robot's starting width as integer value.");
                    int robotWidth = getValue();

                    System.out.println("Enter Robot's starting height as integer value.");
                    int robotHeight = getValue();

                    robot = new Robot(roomWidth, roomHeight, direction, robotWidth, robotHeight);
                    break;
                } else {
                    System.out.println("Enter \"1\" or \"2\"");
                    continue;
                }
            } else {
                System.out.println("Enter integer value");
                continue;
            }
        }
        System.out.println("You create Room of " + (robot.getRoom().width() + 1) + " titles height and of " +
                "" + (robot.getRoom().height() + 1) + " titles wide (W-H(0-" + robot.getRoom().width() + ",0-"
                + robot.getRoom().height() + "))," + "\nRobot's direction is: "
                + robot.getDirection() + ", \nRobot's coordinates are: " +
                "Width-Height(" + robot.getWidth() + "," + robot.getHeight() + ").\n");
    }

    public void actions() {
        Scanner input = new Scanner(System.in);

        outer:
        while (true) {
            instructions();
            System.out.println("Enter action");

            String line = input.nextLine().toUpperCase();
            switch (line) {
                case "M" -> {
                    System.out.println("Enter number of titles to move as integer value.");
                    while (true) {
                        Scanner scanner = new Scanner(System.in);
                        int titles;
                        if (scanner.hasNextInt()) {
                            titles = scanner.nextInt();
                            if (titles == 1) {
                                robot.move();
                                coordinates();
                                break;
                            } else {
                                robot.move(titles);
                                coordinates();
                                break;
                            }
                        } else {
                            System.out.println("Enter integer value");
                            continue;
                        }
                    }
                }
                case "L" -> {
                    robot.turnLeft();
                    coordinates();
                }
                case "R" -> {
                    robot.turnRight();
                    coordinates();
                }
                case "C" -> {
                    robot.getCoordinates();
                    System.out.println();
                }
                case "D" -> {
                    System.out.println("Robot's direction is: " + robot.getDirection());
                    System.out.println();
                }
                case "I" -> instructions();
                case "EXIT" -> {
                    System.out.println("Program ends");
                    break outer;
                }
                default -> System.out.println("Please enter valid value\n");
            }
        }
    }

    public void coordinates() {
        System.out.println("Robot's direction is: " + robot.getDirection() + "\nRoom's size is:" +
                " W-H(0-" + robot.getRoom().width() + ",0-" + robot.getRoom().height() + ")," +
                " \nRobot's coordinates are: W-H(" + robot.getWidth() + "," + robot.getHeight() + ").");
        System.out.println();
    }

    public void instructions() {
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

    public static int getValue() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Enter integer value");
                continue;
            }
        }
    }
}
