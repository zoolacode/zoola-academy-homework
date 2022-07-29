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

    public void quessGame() {
        Random randomGenerator = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's play a game. You need to guess a number from a range you have written");

        int userNumber = 0;
       int randomNumber = randomGenerator.nextInt(10);

        System.out.println("Type a number:");
       do {
            userNumber = scanner.nextInt();

            if (userNumber < randomNumber) {
                System.out.println("Low, go higher");
            } else if (userNumber > randomNumber) {
                System.out.println("High, go lower");
            } else {
                System.out.println("Here's your number:" + " " + userNumber);
            }
        }  while (userNumber != randomNumber);
    }
}