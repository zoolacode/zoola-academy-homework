package com.zoolatech.lecture2.tasks._2;

import java.util.Scanner;

public class RobikDriver {
    public static void main(String[] args) {
        int x;
        int y;
        int height;
        int width;
        Direction dir;
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
            default -> {
                System.out.println("Leaving defaults as 0:0");
                x = 0;
                y = 0;
            }
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

        Robik robocop = new Robik(dir,x,y,width, height);
        robocop.move(1);
        robocop.move1();
        robocop.showPosition();
        robocop.turnLeft();
        robocop.turnRight();
    }

}
