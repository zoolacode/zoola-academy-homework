package com.zoolatech.lecture1.tasks._10;

import java.util.Random;
import java.util.Scanner;


/**
 * Write a program that simulates the guess a number game.
 * The program should generate a random number between 1 and N
 * (N should be read from the input) and the user needs to guess it.
 * If the user enters a number less than guessed, the program needs to output “Larger”.
 * If the user enters a number greater than guessed - the program should output “Smaller”.
 * If the user guesses the number correctly - the program should output “That’s it!” and finish.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputRangeNumber = scanner.nextInt();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(inputRangeNumber) + 1;
        int inputNumber = scanner.nextInt();
        while(inputNumber != randomNumber){
            if(inputNumber>randomNumber){
                System.out.println("Smaller");
            }
            else {
                System.out.println("Larger");
            }
            inputNumber = scanner.nextInt();
        }
        System.out.println("That’s it!");
        scanner.close();
    }
}
