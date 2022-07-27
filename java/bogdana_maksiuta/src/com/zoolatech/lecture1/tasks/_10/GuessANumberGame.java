package com.zoolatech.lecture1.tasks._10;

import java.util.Random;
import java.util.Scanner;

/**
 * 10. Write a program that simulates the guess a number game.
 * The program should generate a random number between 1 and N (N should be read from the input)
 * and the user needs to guess it. If the user enters a number less than guessed,
 * the program needs to output “Larger”. If the user enters a number greater than guessed -
 * the program should output “Smaller”. If the user guesses the number correctly -
 * the program should output “That’s it!” and finish.
 * Input: 10
 * Input: 7
 * Output: Smaller
 * Input: 3
 * Output: Larger
 * Input: 5
 * Output: That’s it!
 */
public class GuessANumberGame {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        config();
    }

    public static void config () {
        int maxLimit = 0;
        while (maxLimit < 2) {
            System.out.println("Start \nEnter the number \nFrom 2: ");
            maxLimit = scanner.nextInt();
            if (maxLimit >= 2) {
                game(maxLimit, randomNumber(maxLimit));
            } else {
                System.out.println("Invalid value. Try again");
            }
        }
    }

    public static int randomNumber (int maxLimit) {
        Random random = new Random();
        return random.nextInt(maxLimit) + 1;
    }

    public static void game (int maxLimit, int randomNumber) {
        System.out.println("Pick a number between 1 and " + maxLimit + ". Enter your guess: ");
        int inputNumber;
        do {
            inputNumber = scanner.nextInt();
            if (inputNumber < 1) {
                System.out.println("Nice try! But range is from 1 to " + maxLimit);
            } else if (inputNumber > maxLimit) {
                System.out.println("Nice try! But range is from 1 to " + maxLimit);
            } else if (inputNumber < randomNumber) {
                System.out.println("Larger");
            } else if (inputNumber > randomNumber) {
                System.out.println("Smaller");
            }
        } while (inputNumber != randomNumber);
        System.out.println("That’s it!");
    }
}

