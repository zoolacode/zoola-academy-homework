package com.zoolatech.lecture1.tasks._10;

import java.util.Random;
import java.util.Scanner;

/**
 * Write a program that simulates the guess a number game.
 * The program should generate a random number between 1 and N (N should be read from the input)
 * and the user needs to guess it. If the user enters a number less than guessed, the program needs to output “Larger”.
 * If the user enters a number greater than guessed - the program should output “Smaller”.
 * If the user guesses the number correctly - the program should output “That’s it!” and finish.
 **/
public class Task10 {

    void guessNumber(int N) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(N);
        boolean guess = false;
        while (!guess) {
            int number = sc.nextInt();
            if (number < randomNumber) {
                printSentence("Larger");
            } else if (number > randomNumber) {
                printSentence("Smaller");
            } else {
                printSentence("That's it");
                guess = true;
            }
        }
    }

    void printSentence(String sentence) {
        System.out.println(sentence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task10 task10 = new Task10();
        task10.guessNumber(sc.nextInt());
    }
}
