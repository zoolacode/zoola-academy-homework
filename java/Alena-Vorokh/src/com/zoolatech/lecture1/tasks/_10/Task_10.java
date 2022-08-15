package com.zoolatech.lecture1.tasks._10;

/* Write a program that simulates the guess a number game.
The program should generate a random number between 1 and N (N should be read from the input)
 and the user needs to guess it. If the user enters a number less than guessed, the program needs
 to output “Larger”. If the user enters a number greater than guessed - the program should output “Smaller”.
 If the user guesses the number correctly - the program should output “That’s it!” and finish.*/


import java.util.Random;
import java.util.Scanner;

public class Task_10 {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input max value: ");
        int N = scanner.nextInt();
        Random rnd = new Random();
        int secretNumber = rnd.nextInt(N);
        // Check
        // System.out.println("Number = " + secretNumber);
        System.out.println("Input your variant: ");
        int yourNumber = scanner.nextInt();
        while (yourNumber != secretNumber){
            if (yourNumber > secretNumber){
                System.out.println("Larger!");
            }
            if (yourNumber < secretNumber){
                System.out.println("Smaller!");
            }
            System.out.println("Input your next variant: ");
            int yourNextNumber = scanner.nextInt();
            yourNumber = yourNextNumber;
        }
        outer:
        while (yourNumber == secretNumber){
            System.out.println("That is it!");
            break outer;
        }

    }
}
