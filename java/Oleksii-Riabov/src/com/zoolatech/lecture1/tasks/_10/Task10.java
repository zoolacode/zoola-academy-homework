package com.zoolatech.lecture1.tasks._10;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that simulates the guess a number game. The program should generate a random
 * number between 1 and N (N should be read from the input) and the user needs to guess it.
 * If the user enters a number less than guessed, the program needs to output “Larger”. If the
 * user enters a number greater than guessed - the program should output “Smaller”.
 * If the user guesses the number correctly - the program should output “That’s it!” and finish.
 */

public class Task10 {

    public static void main(String[] args) {

        randomGenerator();
    }

    public static void randomGenerator() {
        int randomNumber;

        Scanner scanner = new Scanner(System.in);

        Random randomGenerator = new Random();

        if(scanner.hasNextInt()){
            randomNumber = randomGenerator.nextInt(scanner.nextInt());
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        guessNumber(randomNumber);
    }

    public static void guessNumber(int randomNumber) {

        boolean win = false;
        int guessNumber;

        while(!win) {

            Scanner scanner = new Scanner(System.in);

            if(scanner.hasNextInt()){
                guessNumber = scanner.nextInt();
            } else {
                throw new IllegalArgumentException("Enter numeric value");
            }

            System.out.println(guessNumber);

            if (guessNumber == randomNumber) {
                System.out.println("That's it!");
                win = true;
            } else if (guessNumber > randomNumber) {
                System.out.println("Larger");
            } else if (guessNumber < randomNumber) {
                System.out.println("Smaller");
            }
        }
    }
}
