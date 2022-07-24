package com.zoolatech.lecture2.tasks._2.old;

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

public class SimpleRobot {
    enum Direction {   //set direction variants
        WEST,
        EAST,
        NORTH,
        SOUTH
    }
    private int x; // this will be a position on x-axis (along width)
    private int y;  // this will be a position along y-axis (along height)
    private int width;  // this will be a width value
    private int height;  // this will be a height value
    private Direction dir;  // we set a direction
    private String compass; //to convert enum value to human-readable output


    {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Set the width of the room:");
            width = scanner.nextInt();
        } while (width <= 0);

        do {
            System.out.println("Set the height of the room:");
            height = scanner.nextInt();
        } while (height <= 0);

        System.out.println("Default coordinates are 0:0. Set custom? (y/n)");
        if (scanner.next().charAt(0) == 'y') {
            do {
                System.out.println("Enter x (width) axis coordinates " +
                        "(must be > 0 and < room width):");
                x = scanner.nextInt();
            } while (x < 0 || x >= width);

            do {
                System.out.println("Enter y (height) axis coordinates " +
                        "(must be > 0 and < room height):");
                y = scanner.nextInt();
            } while (y < 0 || y >= height);
        }


        System.out.println("Default direction is South. Set custom? (y/n)");
        if (scanner.next().charAt(0) == 'y') {
            System.out.println("Possible variants are: N, E, S, W");
            char custDir = scanner.next().charAt(0);
            if (custDir == 'N') {
                dir = Direction.NORTH;
            } else if (custDir == 'E') {
                dir = Direction.EAST;
            } else if (custDir == 'S') {
                dir = Direction.SOUTH;
            } else if (custDir == 'W') {
                dir = Direction.WEST;
            } else {
                System.out.println("Unknown parameter. Setting to default (East).");
            }
        } else dir = Direction.EAST;  //set default dir to East

        if (dir == Direction.WEST) {  //convert enum value to human-readable output
            compass = "West";
        } else if (dir == Direction.EAST) {
            compass = "East";
        } else if (dir == Direction.NORTH) {
            compass = "North";
        } else if (dir == Direction.SOUTH) {
            compass = "South";
        }
    }

    public void move(int steps) {

        System.out.println("Moving " + steps + " step(s) to " + compass + ".");
        if (steps > 0) {

            if (dir == Direction.EAST) {
                if ((x + steps) < width) {
                    x += steps;
                } else {
                    x = width - 1;
                    System.out.println("Reached Eastern wall! Change direction");
                }
            } else if (dir == Direction.WEST) {
                if ((x - steps) >= 0) {
                    x -= steps;
                } else {
                    x = 0;
                    System.out.println("Reached Western wall! Change direction");
                }
            } else if (dir == Direction.SOUTH) {
                if ((y + steps) < height) {
                    y += steps;
                } else {
                    y = height - 1;
                    System.out.println("Reached Southern wall! Change direction");
                }
            } else if (dir == Direction.NORTH) {
                if ((y - steps) >= 0) {
                    y -= steps;
                } else {
                    y = 0;
                    System.out.println("Reached Northern wall! Change direction");
                }
            }
        } else {
            System.out.println("Robot made no moves!");
        }
    }

    public void moveAndShow(int steps) {

        System.out.println("Moving " + steps + " step(s) to " + compass + ".");
        if (steps > 0) {

            if (dir == Direction.EAST) {
                if ((x + steps) < width) {
                    x += steps;
                } else {
                    x = width - 1;
                    System.out.println("Reached Eastern wall! Change direction");
                }
            } else if (dir == Direction.WEST) {
                if ((x - steps) >= 0) {
                    x -= steps;
                } else {
                    x = 0;
                    System.out.println("Reached Western wall! Change direction");
                }
            } else if (dir == Direction.SOUTH) {
                if ((y + steps) < height) {
                    y += steps;
                } else {
                    y = height - 1;
                    System.out.println("Reached Southern wall! Change direction");
                }
            } else if (dir == Direction.NORTH) {
                if ((y - steps) >= 0) {
                    y -= steps;
                } else {
                    y = 0;
                    System.out.println("Reached Northern wall! Change direction");
                }
            }
            showPosition();
        } else {
            System.out.println("Robot made no moves!");
        }
    }

    public void turnLeft() {
        if (dir == Direction.SOUTH) {
            dir = Direction.EAST;
        } else if (dir == Direction.EAST) {
            dir = Direction.NORTH;
        } else if (dir == Direction.NORTH) {
            dir = Direction.WEST;
        } else if (dir == Direction.WEST) {
            dir = Direction.SOUTH;
        }
    }

    public void turnRight() {
        if (dir == Direction.SOUTH) {
            dir = Direction.WEST;
        } else if (dir == Direction.WEST) {
            dir = Direction.NORTH;
        } else if (dir == Direction.NORTH) {
            dir = Direction.EAST;
        } else if (dir == Direction.EAST) {
            dir = Direction.SOUTH;
        }
    }

    public void showPosition() {
        System.out.println("Robot's coordinates are (x:y): (" +
                x + ":" + y + ").");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) { // first print a line wit a symbol
                if (i == y && j == x) {   // markup position
                    System.out.print("|@ |");
                } else {
                    System.out.print(" || ");
                }
            }
            System.out.println();  // second statement, this starts a new line
        }
        System.out.println("Direction: " + compass + ".");
        System.out.println(); // this makes a new line at the bottom
    }


}


class SimpleRobotDriver {
    public static void main(String[] args) {
        SimpleRobot robic = new SimpleRobot();
        robic.move(1);
        robic.showPosition();
        robic.turnLeft();
        robic.moveAndShow(3);
        robic.turnRight();
        robic.moveAndShow(2);
    }
}
