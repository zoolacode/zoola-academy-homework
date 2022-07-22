package com.zoolatech.lecture1.tasks._10;
import java.util.Scanner;
import java.util.Random;

/**
 *Write a program that simulates the guess a number game. The program should generate a random number
 *  between 1 and N (N should be read from the input) and the user needs to guess it.
 *  If the user enters a number less than guessed, the program needs to output “Larger”.
 *  If the user enters a number greater than guessed - the program should output “Smaller”.
 *  If the user guesses the number correctly - the program should output “That’s it!” and finish.
 */


public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input game limit: ");
        int n = sc.nextInt();
        System.out.println("Game started!\n");
        game(randIntN(n));
    }


    public static int randIntN(int n){
        //return random integer value from 1 to N
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(n) + 1;
    }


    public static void game(int randomNumber){
        //larger-smaller game code
        int number = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Input number: ");
            number = sc.nextInt();
            if (randomNumber == number){
                System.out.println("That’s it!");
            }else if(randomNumber < number){
                System.out.println("Smaller");
            }else{
                System.out.println("Larger");
            }
            System.out.println();
        }while (randomNumber!=number);
    }
}
