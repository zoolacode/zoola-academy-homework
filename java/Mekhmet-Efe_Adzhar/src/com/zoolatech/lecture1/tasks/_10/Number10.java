package com.zoolatech.lecture1.tasks._10;

import java.util.Scanner;
import java.util.Random;

/**
 * Write a program that simulates the guess a number game.
 * The program should generate a random number between 1 and N (N should be read from the input)
 * and the user needs to guess it. If the user enters a number less than guessed,
 * the program needs to output “Larger”.
 * If the user enters a number greater than guessed - the program should output “Smaller”.
 * If the user guesses the number correctly - the program should output “That’s it!” and finish.
 */

public class Number10 {
    public static void main(String[] args) {
        Number10 number10 = new Number10();
        number10.quessGame();
    }

    private void quessGame() {
        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);
        int rangeOfNumbers;
        int userNumber = 0;

        System.out.println("Let's play a game. You need to guess a number from a range you have written");

        rangeOfNumbers = randomGenerator.nextInt(10);

        while (userNumber != rangeOfNumbers) {

            System.out.println("Type a number:");
            userNumber = scanner.nextInt();

            if (userNumber < rangeOfNumbers) {
                System.out.println("Low, go higher\n");
            } else if (userNumber > rangeOfNumbers) {
                System.out.println("High, go lower\n");
            } else {
                System.out.println("Here's your number:" + " " + userNumber);
            }
        }
    }
}