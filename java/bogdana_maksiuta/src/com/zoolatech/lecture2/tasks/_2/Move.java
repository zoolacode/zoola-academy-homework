package com.zoolatech.lecture2.tasks._2;

public class Move {
    Coordinates coordinates = new Coordinates();
    Direction direction = new Direction();

    public void moving() {
        int side;
        System.out.println("\nMoving - Press '1' \nTurn the other way - Press '2' \nDisplay the current position - " +
                "Press '3' \nStop - Press '4'");

        int moving = Config.scanner.nextInt();
        if (moving == 1) {
            switch (Config.direction) {
                case "east" -> {
                    Config.w++;
                    direction.eastDirection();
                    moving();
                }
                case "west" -> {
                    Config.w--;
                    direction.westDirection();
                    moving();
                }
                case "north" -> {
                    Config.h--;
                    direction.northDirection();
                    moving();
                }
                case "south" -> {
                    Config.h++;
                    direction.southDirection();
                    moving();
                }
            }
        } else if (moving == 2) {
            switch (Config.direction) {
                case "east", "west" -> {
                    System.out.println("You can turn to: \nNORTH - press '1'\nSOUTH - Press '2'");
                    side = Config.scanner.nextInt();
                    if (side == 1) {
                        System.out.println("Changing accept.");
                        direction.northDirection();
                        moving();
                    } else if (side == 2) {
                        System.out.println("Changing accept.");
                        direction.southDirection();
                        moving();
                    } else {
                        System.out.println("Invalid choice. Try again");
                        moving();
                    }
                }
                case "north", "south" -> {
                    System.out.println("You can turn to: \nWEST - press '1'\nEAST - Press '2'");
                    side = Config.scanner.nextInt();
                    if (side == 1) {
                        System.out.println("Changing accept.");
                        direction.westDirection();
                        moving();
                    } else if (side == 2) {
                        System.out.println("Changing accept.");
                        direction.eastDirection();
                        moving();
                    } else {
                        System.out.println("Invalid choice. Try again");
                        moving();
                    }
                }
            }
        } else if (moving == 3) {
            coordinates.currentPosition();
            moving();
        } else if (moving == 4) {
            System.out.println("Bye");
        } else {
            System.out.println("Invalid number. Try again");
            moving();
        }
    }
}
