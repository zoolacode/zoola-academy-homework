package com.zoolatech.lecture2.tasks._2;

/**
 * Define a class that represents a robot, which moves in a room of a width W
 * and a height of H. The class should provide methods to move a robot forward
 * by either 1 or N tiles and turn it either left or right by 90 degrees from
 * the current direction. The class should also provide methods to get the robot's
 * current location and direction.
 * The north-west corner of a room is represented by coordinates (0,0);
 * north-east - (W-1, 0); south-east - (W-1, H-1); south-west - (0, H-1).
 * By default, a robot should be placed in the north-west corner facing south direction.
 * However, it should be also possible to give any coordinates and direction as the
 * initial robot location. Robot must not be able to get outside a room - in
 * such case the robot should move as much as possible to the room border, print
 * a warning message and stop. All next moves in the same direction should be prevented.
 */

import java.util.Scanner;

public class Robik {
    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    static Direction dir;
    static int x; // coordinates
    static int y;
    static int width;
    static int height;

    public void showPosition() {
        System.out.println("Your coordinates are: " + x + ":" + y
                           + ". Direction is: " + dir + ".");
    }

    public void move(int steps) {
        System.out.println("Moving " + steps + " steps to " + dir + ".");
        switch (dir) {
            case NORTH -> {
                if ((y - steps) >= 0) {
                    y -= steps;
                } else {
                    y = 0;
                    System.out.println("Reached Northern wall! Change direction!");
                }

            }
            case EAST -> {
                if ((x + steps) < width) {
                    x += steps;
                } else {
                    x = width - 1;
                    System.out.println("Reached Eastern wall! Change direction!");
                }
            }
            case WEST -> {
                if ((x - steps) >= 0) {
                    x -= steps;
                } else {
                    x = 0;
                    System.out.println("Reached Western wall! Change direction!");
                }
            }
            case SOUTH -> {
                if ((y + steps) < height) {
                    y += steps;
                } else {
                    y = height - 1;
                    System.out.println("Reached Southern wall! Change direction!");
                }
            }
        }
        System.out.println("Your coordinates are: " + x + ":" + y);
    }

    public void move1() {
        move(1);
    }

    public void turnLeft() {
        switch (dir) {
            case NORTH -> dir = Direction.WEST;
            case EAST -> dir = Direction.NORTH;
            case WEST -> dir = Direction.SOUTH;
            case SOUTH -> dir = Direction.EAST;
        }
        System.out.println("Direction changed to: " + dir);
    }

    public void turnRight() {
        switch (dir) {
            case NORTH -> dir = Direction.EAST;
            case EAST -> dir = Direction.SOUTH;
            case WEST -> dir = Direction.NORTH;
            case SOUTH -> dir = Direction.WEST;
        }
        System.out.println("Direction changed to: " + dir);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //set room dimensions (x and y), must not be <=0
        do {
            System.out.println("Set room width:");
            width = scanner.nextInt();
        } while (width <= 0);

        do {
            System.out.println("Set room height:");
            height = scanner.nextInt();
        } while (height <= 0);

        //set coordinates
        System.out.println("Set custom coordinates? (y/n)");
        char custXY = scanner.next().charAt(0);
        switch (custXY) {
            case 'y', 'Y' -> {
                do {
                    System.out.println("Set a position along width (x)");
                    x = scanner.nextInt();
                } while (x < 0);
                do {
                    System.out.println("Set a position along height (y)");
                    y = scanner.nextInt();
                } while (y < 0);
            }
            default -> System.out.println("Leaving defaults as 0:0");
        }

        //set direction
        System.out.println("Set custom direction? (y/n)");
        char custDirTrue = scanner.next().charAt(0);
        switch (custDirTrue) {
            case 'y', 'Y' -> {
                System.out.println("Set direction: (N / W / S / E)");
                char custDir = scanner.next().charAt(0);
                switch (custDir) {
                    case 'n', 'N' -> {
                        System.out.println("Direction: North.");
                        dir = Direction.NORTH;
                    }
                    case 'w', 'W' -> {
                        System.out.println("Direction: West.");
                        dir = Direction.WEST;
                    }
                    case 's', 'S' -> {
                        System.out.println("Direction: South.");
                        dir = Direction.SOUTH;
                    }
                    case 'e', 'E' -> {
                        System.out.println("Direction: East.");
                        dir = Direction.EAST;
                    }
                    default -> throw new IllegalArgumentException("Wrong input. Must be N / E / S / W.");
                }
                ;
            }
            default -> {
                System.out.println("Direction: South.");
                dir = Direction.SOUTH;
            }
        }

        Robik robocop = new Robik();
        robocop.showPosition();
        robocop.move(1);
        robocop.move1();
        robocop.turnLeft();
        robocop.turnRight();
    }

}
