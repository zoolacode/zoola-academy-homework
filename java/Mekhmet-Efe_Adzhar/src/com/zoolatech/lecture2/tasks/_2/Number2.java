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

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Number2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RobotGame robotGame = new RobotGame();
        boolean exit = false;
        System.out.println("HELLO AND WELCOME!. Please input a W(width)");
        robotGame.setW(scanner.nextInt());
        System.out.println("and H(height) of a room");
        robotGame.setH(scanner.nextInt());
        System.out.println("Your room size is:");
        robotGame.getRoomSize();
        System.out.println("Press 0 to continue");
        scanner.nextInt();
        System.out.println();
        System.out.println("Please input a coordinates for robot.\nThere must be smaller than your room :)");
        System.out.println("Input X and then Y");
        robotGame.setCoordinates(scanner.nextInt(), scanner.nextInt());
        System.out.println("Your coordinates are:");
        robotGame.getCoordinates();
        System.out.println();
        System.out.println("Press 0 to continue");
        System.out.println();
        System.out.println("Set direction where your robot is going");
        System.out.println("0. SOUTH,\n1. NORTH,\n2. WEST,\n3. EAST");
        Direction direction = Direction.values()[Integer.parseInt(scanner.next())];

        switch (direction.toString()) {
            case "SOUTH" -> {
                System.out.println("Direction is SOUTH\n");
                robotGame.setDirection(Direction.SOUTH);
            }
            case "NORTH" -> {
                System.out.println("Direction is NORTH\n");
                robotGame.setDirection(Direction.NORTH);
            }
            case "WEST" -> {
                System.out.println("Direction is WEST\n");
                robotGame.setDirection(Direction.WEST);
            }
            case "EAST" -> {
                System.out.println("Direction is EAST\n");
                robotGame.setDirection(Direction.EAST);
            }
            default -> throw new InputMismatchException("Wrong input");
        }

        System.out.println("1.Move Forward.\n2.ChangeDirection;\n3.Get coordinates;\n4.Get directions;\n5.Exit");

        while (!exit) {
            switch (scanner.nextInt()) {
                case 1:
                    robotGame.moveForward();
                    System.out.println("Moving On");
                    break;
                case 2:
                    System.out.println("1.Turn Left;\n2.Turn Right;");
                    if (scanner.nextInt() == 1) {
                        robotGame.turnLeft();
                        System.out.println("Turned left");

                    }
                    else  {
                        robotGame.turnRight();
                        System.out.println("Turned right");
                    }
                    break;
                case 3:
                    robotGame.getCoordinates();
                    break;
                case 4:
                    robotGame.getDirection();
                    break;
                case 5:
                    System.out.println("Shutting down");
                    exit = true;
                    break;
                default:
                    break;
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

    private int w;
    private int h;
    private int x;
    private int y;
    private int[] coordinates = {x, y};
    int[][] roomSize;

    private Direction direction = Direction.SOUTH;

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void getRoomSize() {
        roomSize = new int[h][w];
        for (int[] row : roomSize) {
            for (int i : row) {
                System.out.print(i);
            }
            System.out.println();
        }
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void getCoordinates() {
        System.out.println(Arrays.toString(coordinates));
    }

    public void getDirection() {
        System.out.println(direction);
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        this.coordinates = new int[]{x, y};
    }

    public void moveForward() {
        if (direction == Direction.SOUTH) {
            if (y < h) {
                y += 1;
                setCoordinates(x, y);
            }
            if (y == h) {
                System.out.println("WARNING. OUT OF RANGE. TURN LEFT");
            }
        }
        if (direction == Direction.NORTH) {
            if (y > 0) {
                y -= 1;
                setCoordinates(x, y);
            } else if (y <= 0) {
                System.out.println("WARNING. OUT OF RANGE");
            }
        }
        if (direction == Direction.WEST) {
            if (x > 0) {
                x -= 1;
                setCoordinates(x, y);
            }
            if (x <= 0) {
                System.out.println("WARNING. OUT OF RANGE");
            }
        }
        if (direction == Direction.EAST) {
            if (x < w) {
                x += 1;
                setCoordinates(x, y);
            }
            if (x >= w) {
                System.out.println("WARNING. OUT OF RANGE");
            }
        }
    }

    public void turnLeft() {
        if (direction == Direction.SOUTH) {
            direction = Direction.EAST;
            setDirection(direction);
        } else if (direction == Direction.EAST) {
            direction = Direction.NORTH;
            setDirection(direction);
        } else if (direction == Direction.NORTH) {
            direction = Direction.WEST;
            setDirection(direction);
        } else if (direction == Direction.WEST) {
            direction = Direction.SOUTH;
            setDirection(direction);
        }
    }

    public void turnRight() {
        if (direction == Direction.SOUTH) {
            direction = Direction.WEST;
            setDirection(direction);
        } else if (direction == Direction.WEST) {
            direction = Direction.NORTH;
            setDirection(direction);
        } else if (direction == Direction.NORTH) {
            direction = Direction.EAST;
            setDirection(direction);
        } else if (direction == Direction.EAST) {
            direction = Direction.SOUTH;
            setDirection(direction);
        }
    }
}