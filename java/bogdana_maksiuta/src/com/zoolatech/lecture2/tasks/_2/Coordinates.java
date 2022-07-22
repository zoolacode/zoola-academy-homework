package com.zoolatech.lecture2.tasks._2;

public class Coordinates {
    Direction direction = new Direction();
    public void start () {
        System.out.println("Welcome! \nPress '1' to Start from charging station " +
                "\nPress '2' to Start from custom coordinates");
        int startChoice = Config.scanner.nextInt();
        if (startChoice == 1) {
            positionByDefault();
            currentPosition();
        } else if (startChoice == 2) {
            customerCoordinates();
            currentPosition();
        } else {
            System.out.println("I dont understand you. Try again");
            start();
        }
    }

    public void positionByDefault () {
        Config.h = 0;
        Config.w = 0;
        direction.southDirection();
    }

    public void customerCoordinates () {
        System.out.println("Your room-size is 10 x 10. Where I need to start?");
        System.out.println("Height (from 0 to 9): ");
        Config.h = Config.scanner.nextInt();
        if (Config.h >= 0 && Config.h <= Config.HEIGHT_ROOM-1 ) {
            System.out.println("Weight (from 0 to 9): ");
            Config.w = Config.scanner.nextInt();
            if (Config.w >= 0 && Config.w <= Config.WIDTH_ROOM-1 ) {
                System.out.println("Choose the directory : \n'1' - south \n'2' - east \n'3' - north \n'4' - west");
                int choiceDirection = Config.scanner.nextInt();
                if (choiceDirection == 1) {
                    direction.southDirection();
                } else if (choiceDirection == 2) {
                    direction.eastDirection();
                } else if (choiceDirection == 3) {
                    direction.northDirection();
                } else if (choiceDirection == 4) {
                    direction.westDirection();
                } else {
                    invalidValueInPosition();
                }
            } else {
                invalidValueInPosition();
            }
        } else {
            invalidValueInPosition();
        }
    }

    public void invalidValueInPosition () {
        System.out.println("Invalid value. Do you want to try again? \n'1' - yes '2' - no");
        int tryAgain = Config.scanner.nextInt();
        if (tryAgain == 1) {
            customerCoordinates();
        } if (tryAgain == 2) {
            positionByDefault();
        } else {
            System.out.println("You need to try harder. I'll start from my charging station");
            positionByDefault();
        }
    }

    public void currentPosition() {
        System.out.println("Your current position is: " + "[" + Config.h + " : " + Config.w + "] [height : weight]" +
                "\nDirection: " + Config.direction);
    }
}
