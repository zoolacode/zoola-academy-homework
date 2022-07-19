package com.zoolatech.lecture1.tasks._7;

import java.util.Scanner;

/**
 * Write a program that prints all odd numbers from N to 1. N should be read from the input.
 * Every number should be printed on the new line. Create two versions of the program: one
 * should use the for loop, second - the while loop.
 */

public class Task7 {

    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt()){
            number = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Enter integer value");
        }

        printOddNumbersForLoop(number);
        System.out.println();
        printOddNumbersWhileLoop(number);
    }

    public static void printOddNumbersForLoop(int number) {

        for (int i = --number; i >= 1; i--) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void printOddNumbersWhileLoop(int number) {

        while (number >= 1) {
            number--;
            if (number % 2 != 0) {
                System.out.println(number);
            }
        }
    }
}
