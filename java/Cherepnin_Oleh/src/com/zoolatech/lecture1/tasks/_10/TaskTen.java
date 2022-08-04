package com.zoolatech.lecture1.tasks._10;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that simulates the guess a number game. The program should generate a random number between 1 and N
 * (N should be read from the input) and the user needs to guess it. If the user enters a number less than guessed,
 * the program needs to output “Larger”. If the user enters a number greater than guessed - the program should output
 * “Smaller”. If the user guesses the number correctly - the program should output “That’s it!” and finish.
 * Input: 10
 * Input: 7
 * Output: Smaller
 * Input: 3
 * Output: Larger
 * Input: 5
 * Output: That’s it!
 */
public class TaskTen {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        guessNumber();
    }

    public static void guessNumber() {
        System.out.println("Input max number");
        int randomInt = new Random().nextInt(1, scanner.nextInt() + 1);
        int guessedNumber = 0;

        do {
            System.out.println("Input guessed number");
            guessedNumber = scanner.nextInt();
            if (guessedNumber == randomInt) {
                System.out.println("That’s it!");
            } else if (guessedNumber > randomInt) {
                System.out.println("Smaller");
            } else {
                System.out.println("Bigger");
            }
        } while (guessedNumber != randomInt);

    }
}
