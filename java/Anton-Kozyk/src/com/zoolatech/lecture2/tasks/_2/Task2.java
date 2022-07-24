package com.zoolatech.lecture2.tasks._2;

import java.util.Scanner;

/**
 * Define a class that represents a robot, which moves in a room of a width W and a height
 * of H. The class should provide methods to move a robot forward by either 1 or N tiles
 * and turn it either left or right by 90 degrees from the current direction. The class should
 * also provide methods to get the robot's current location and direction.
 * The north-west corner of a room is represented by coordinates (0,0); north-east - (W-1,
 * 0); south-east - (W-1, H-1); south-west - (0, H-1). By default, a robot should be placed
 * in the north-west corner facing south direction. However, it should be also possible to
 * give any coordinates and direction as the initial robot location. Robot must not be able
 * to get outside of a room - in such case the robot should move as much as possible to the
 * room border, print a warning message and stop. All next moves in the same direction should
 * be prevented.
 */

/**
 * The size of the room is set when creating an object of the robot class. Also, when creating,
 * you can set the initial coordinates and direction for the robot (use the format x, y, direction,
 * Width, Height for this). Now the robot will follow the instructions from the code. He can go
 * forward a certain number of steps, or turn left and right. Using the moveForward() method
 * without arguments the robot will take one step, if you set a number in the method (moveForward(2))
 * the robot will take the corresponding number of steps. Also note that left or right is relative
 * to the direction of the robot. That is, if the robot is standing in the direction of the South,
 * turning to the left, it will turn in the direction of the East. If the number of steps entered
 * exceeds the size of the room, the robot will stop at its border. printPosition() method displays
 * the compass, current position, direction, as well as a map with a picture of a robot on it (it can
 * be displayed in 4 ways, depending on the direction - [ > ], [ < ], [/\ ] , [\/ ]).
 */

public class Task2 {
    public static void main(String[] args) {
        Robot robot = new Robot(5, 5);
        robot.printPosition();
        robot.moveForward(4);
        robot.moveForward();
        robot.turnLeft();
        robot.moveForward();
        robot.printPosition();
    }
}

class Robot {
    int x;
    int y;
    char direction;

    int Width;
    int Height;

    final char S = 'S';
    final char N = 'N';
    final char W = 'W';
    final char E = 'E';

    Robot(int Width, int Height) {
        this.x = 0;
        this.y = 0;
        this.direction = S;
        this.Width = Width;
        this.Height = Height;
    }

    Robot(int x, int y, char direction, int Width, int Height) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.Width = Width;
        this.Height = Height;
    }

    public void moveForward() {
        moveForward(1);
    }

    public void moveForward(int step) {
        System.out.println("Trying to do " + step + " step(s) to " + direction);
        if (step > 0) {
            switch (direction) {
                case S -> {
                    if (y + step < Height) {
                        y += step;
                    } else {
                        y = Height - 1;
                        System.out.println("You can't go South anymore, please change direction.");
                    }
                }
                case E -> {
                    if (x + step < Width) {
                        x += step;
                    } else {
                        x = Width - 1;
                        System.out.println("You can't go East anymore, please change direction.");
                    }
                }
                case N -> {
                    if (y - step >= 0) {
                        y -= step;
                    } else {
                        y = 0;
                        System.out.println("You can't go North anymore, please change direction.");
                    }
                }
                case W -> {
                    if (x - step >= 0) {
                        x -= step;
                    } else {
                        x = 0;
                        System.out.println("You can't go West anymore, please change direction.");
                    }
                }
            }
            getPosition();
        } else {
            System.out.println("Nothing happened...");
        }
    }

    public void turnLeft() {
        direction = switch (direction) {
            case S -> E;
            case E -> N;
            case N -> W;
            case W -> S;
            default -> throw new IllegalStateException("Unknown direction: " + direction);
        };
        System.out.println("Direction changed to " + direction + "\n");
    }

    public void turnRight() {
        direction = switch (direction) {
            case S -> W;
            case W -> N;
            case N -> E;
            case E -> S;
            default -> throw new IllegalStateException("Unknown direction: " + direction + "\n");
        };
        System.out.println("Direction changed to " + direction);
    }

    public void printPosition() {
        System.out.println(
                        """
                        Compass
                           N
                        W     E
                           S""");

        getPosition();
        System.out.println("Direction: " + direction + "\n");
        for (int i = 0; i < Height; i++) {
            for (int j = 0; j < Width; j++) {
                if (i == y && j == x) {
                    System.out.print(switch (direction) {
                        case S -> "[\\/ ]";
                        case W -> "[ < ]";
                        case N -> "[/\\ ]";
                        case E -> "[ > ]";
                        default -> throw new IllegalStateException("Unexpected direction: " + direction);
                    });
                } else {
                    System.out.print("[" + i + ":" + j + "]");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    class RobotsPosition {
        int x = Robot.this.x;
        int y = Robot.this.y;
    }

    public RobotsPosition getPosition() {
        RobotsPosition robotsPosition = new RobotsPosition();
        System.out.println("\nYour current position is [" +
                robotsPosition.y + ":" + robotsPosition.x + "]");
        return robotsPosition;
    }

    public char getDirection() {
        System.out.println(direction);
        return direction;
    }
}


