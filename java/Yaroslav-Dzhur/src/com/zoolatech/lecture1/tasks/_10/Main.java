package com.zoolatech.lecture1.tasks._10;

/*
Write a program that simulates the guess a number game. The program should generate a random number
between 1 and N (N should be read from the input) and the user needs to guess it.
If the user enters a number less than guessed, the program needs to output “Larger”.
If the user enters a number greater than guessed - the program should output “Smaller”.
If the user guesses the number correctly - the program should output “That’s it!” and finish.
*/

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a max int: ");
        Random randomGenerator = new Random();
        int maxNum = input.nextInt();
        System.out.println("Can you guess the number?");

        int randomNumber = ThreadLocalRandom.current().nextInt(1, maxNum + 1);
        while(true){
            Scanner scanner = new Scanner(System.in);
            int enteredNumber = input.nextInt();
            if(enteredNumber == randomNumber){
                System.out.println("That's it!");
                break;
            }
            else if(enteredNumber > randomNumber)
                System.out.println("Smaller");
            else
                System.out.println("Larger");
        }
    }

}