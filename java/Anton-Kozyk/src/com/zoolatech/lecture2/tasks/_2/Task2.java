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
 When you first run the program, you will be asked to enter the dimensions of the
 room (width and height) - they cannot be negative or zero. Next you will be able to enter the initial
 coordinates of the robot, to do this, enter "y" and then specify the desired values,
 keep in mind that these values can only be within the previously defined room
 dimensions. To continue with the default values of the coordinates of the robot,
 simply type any character and press Enter. Now the robot will follow your instructions
 from the code. He can go forward a certain number of steps, or turn left and right. Also
 note that left or right is relative to the direction of the robot. That is, if the robot
 is standing in the direction of the South, turning to the left, it will turn in the
 direction of the East. If the number of steps entered exceeds the size of the room, the
 robot will stop at its border. printPosition() method displays the compass, current
 position, direction, as well as a map with a picture of a robot on it (it can be displayed
 in 4 ways, depending on the direction - [ > ], [ < ], [/\ ] , [\/ ]).
 */

public class Task2 {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.printPosition();
        robot.moveForward(10);
        robot.turnLeft();
        robot.moveForward(4);
        robot.turnLeft();
        robot.moveForward(3);
        robot.printPosition();
        robot.turnLeft();
        robot.printPosition();
        robot.moveForward(4);
        robot.printPosition();
    }
}

class Robot {
    //Start position coordinates
    int x = 0;
    int y = 0;
    char direction = 'S';

    int W; //width of area
    int H; //height of area

    { //Initialization block
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter Width of area: ");
            W = scanner.nextInt();
        } while (W <= 0);

        do {
            System.out.print("Enter Height of area: ");
            H = scanner.nextInt();
        } while (H <= 0);

        System.out.print("If you want to chose start coordinates type \"y\" or" +
                "type any letter to continue with default [0:0]: ");
        if (scanner.next().charAt(0) == 'y') {
            do {
                System.out.print("Enter x: ");
                x = scanner.nextInt();
            } while (x < 0 || x >= W);

            do {
                System.out.print("Enter y: ");
                y = scanner.nextInt();
            } while (y < 0 || y >= H);
        }
    }

    public void moveForward(int step) {
        System.out.println("Trying to do " + step + " step(s) to " + direction);
        if (step > 0) {
            switch (direction) {
                case 'S' -> {
                    if (y + step < H) {
                        y += step;
                    } else {
                        y = H - 1;
                        System.out.println("You can't go South anymore, please change direction.");
                    }
                }
                case 'E' -> {
                    if (x + step < W) {
                        x += step;
                    } else {
                        x = W - 1;
                        System.out.println("You can't go East anymore, please change direction.");
                    }
                }
                case 'N' -> {
                    if (y - step >= 0) {
                        y -= step;
                    } else {
                        y = 0;
                        System.out.println("You can't go North anymore, please change direction.");
                    }
                }
                case 'W' -> {
                    if (x - step >= 0) {
                        x -= step;
                    } else {
                        x = 0;
                        System.out.println("You can't go West anymore, please change direction.");
                    }
                }
            }
            System.out.println("At the moment you are at [" + y + ":" + x + "]\n");
//            printPosition();
        } else {
            System.out.println("Nothing happened...");
        }
    }

    public void turnLeft() {
        direction = switch (direction) {
            case 'S' -> 'E';
            case 'E' -> 'N';
            case 'N' -> 'W';
            case 'W' -> 'S';
            default -> throw new IllegalStateException("Unknown direction: " + direction);
        };
        System.out.println("Direction changed to " + direction + "\n");
    }

    public void turnRight() {
        direction = switch (direction) {
            case 'S' -> 'W';
            case 'W' -> 'N';
            case 'N' -> 'E';
            case 'E' -> 'S';
            default -> throw new IllegalStateException("Unknown direction: " + direction + "\n");
        };
        System.out.println("Direction changed to " + direction);
    }

    public void printPosition() {
        System.out.println(
                "Compass" +
                        "\n   N" +
                        "\nW     E" +
                        "\n   S");

        System.out.println("\nYour current position is [" + y + ":" + x + "]");
        System.out.println("Direction: " + switch (direction) {
            case 'S' -> "South";
            case 'W' -> "West";
            case 'N' -> "North";
            case 'E' -> "East";
            default -> throw new IllegalStateException("Unexpected direction: " + direction);
        });
        System.out.println();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i == y && j == x) {
                    System.out.print(switch (direction) {
                        case 'S' -> "[\\/ ]";
                        case 'W' -> "[ < ]";
                        case 'N' -> "[/\\ ]";
                        case 'E' -> "[ > ]";
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
}
