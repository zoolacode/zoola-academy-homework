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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        game(scanner.nextInt());
    }

    public static void game(int N) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int target = rand.nextInt(N) + 1;
//        System.out.println("|" + target + "|");
        int guess = scanner.nextInt();

        while (guess != target) {
            if (target > guess) {
                System.out.println("Larger");
            } else {
                System.out.println("Smaller");
            }
            guess = scanner.nextInt();
        }
        System.out.println("That's it!");
    }
}
