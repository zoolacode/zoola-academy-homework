package com.zoolatech.lecture2.tasks._2;

/*Define a class that represents a robot, which moves in a room of a width W and a height of H.
The class should provide methods to move a robot forward by either 1 or N tiles and turn it either left or right
by 90 degrees from the current direction.
The class should also provide methods to get the robot's current location and direction.
The north-west corner of a room is represented by coordinates
(0,0); north-east - (W-1, 0); south-east - (W-1, H-1); south-west - (0, H-1).
By default, a robot should be placed in the north-west corner facing south direction.
However, it should be also possible to give any coordinates and direction as the initial
robot location. Robot must not be able to get outside of a room - in such case the robot should
move as much as possible to the room border, print a warning message and stop.
All next moves in the same direction should be prevented.
*/

import java.util.Scanner;

public class Number2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("HELLO AND WELCOME!. Please input width, height, x, y coordinates and Direction");
        RobotGame robotGame = new RobotGame(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), Direction.SOUTH);
        System.out.println("Your room size is:");
        System.out.println(robotGame.getRoomSize() + "\n");
        System.out.println("Your coordinates are:");
        System.out.println(robotGame.getCoordinates() + "\n");
        System.out.println("Set direction where your robot is going. Default direction is SOUTH");
        System.out.println("0. SOUTH,\n1. NORTH,\n2. WEST,\n3. EAST");
        Direction direction = Direction.values()[Integer.parseInt(scanner.next())];
        System.out.println(direction.toString() + "\n");

        System.out.println("1.Move Forward.\n2.Change Direction;\n3.Get coordinates;\n4.Get directions;\n5.Exit");

        while (!exit) {
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Type N steps");
                    int steps = scanner.nextInt();
                    robotGame.moveForward(steps);
                }
                case 2 -> {
                    System.out.println("1.Turn Left;\n2.Turn Right;");
                    if (scanner.nextInt() == 1) {
                        robotGame.turnLeft();
                        System.out.println("Turned left");

                    } else {
                        robotGame.turnRight();
                        System.out.println("Turned right");
                    }
                }
                case 3 -> System.out.println(robotGame.getCoordinates());
                case 4 -> robotGame.getDirection();
                case 5 -> {
                    System.out.println("Shutting down");
                    exit = true;
                }
            }
        }
    }
}

enum Direction {
    SOUTH,
    NORTH,
    WEST,
    EAST
}

class RobotGame {

    private final int width;
    private final int height;
    private int x;
    private int y;
    Direction direction;

    public RobotGame(int width, int height, int x, int y, Direction direction) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String getRoomSize() {
        return "Width: " + width + " " + "Height: " + height;
    }

    public String getCoordinates() {
        return "X: " + x + " " + "Y: " + y;
    }

    public void getDirection() {
        System.out.println(direction);
    }

    public void moveForward(int n) {
        if (n > height || n > width) {
            System.out.println("Amount of steps are greater than a width or height of a room");
        }
        else if ((n + y) > height || (n + x) > width) {
            System.out.println("Can't move forward. Out of bounds.");
        }
        else {
            if (direction == Direction.SOUTH) {
                if (y < height) {
                    y += n;
                }
                if (y == height) {
                    System.out.println("WARNING. OUT OF RANGE");
                }
            } else if (direction == Direction.NORTH) {
                if (y > 0) {
                    y -= n;
                }
                if (y < n) {
                    System.out.println("Out of Bounds");
                }
                if (y == 0) {
                    System.out.println("WARNING. OUT OF RANGE");
                }
            } else if (direction == Direction.WEST) {
                if (x > 0) {
                    x -= n;
                }
                if (x < n) {
                System.out.println("Out of Bounds");
                   }
                if (x == 0) {
                    System.out.println("WARNING. OUT OF RANGE");
                }
            } else if (direction == Direction.EAST) {
                if (x < width) {
                    x += n;
                }
                if (x >= width) {
                    System.out.println("WARNING. OUT OF RANGE");
                }
            }
            System.out.println("Moving On");
        }
    }

    public void turnLeft() {
        switch (direction) {
            case SOUTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.NORTH;
            case NORTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.SOUTH;
        }
    }

    public void turnRight() {
        switch (direction) {
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
        }
    }
}