package com.zoolatech.lecture1.tasks._10;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that simulates the guess a number game. The program should generate
 * a random number between 1 and N (N should be read from the input) and the user
 * needs to guess it. If the user enters a number less than guessed, the program needs to
 * output “Larger”. If the user enters a number greater than guessed - the program should
 * output “Smaller”. If the user guesses the number correctly - the program should output
 * “That’s it!” and finish.
 */

public class Task10 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        game(scanner.nextInt());
    }

    public static void game(int N) {
        Random rand = new Random();
        int target = rand.nextInt(N) + 1;
        int guess;

        do {
            guess = scanner.nextInt();
            if (target > guess) {
                System.out.println("Larger");
            } else if (target < guess) {
                System.out.println("Smaller");
            }
        } while (guess != target);
        System.out.println("That's it!");
    }
}
