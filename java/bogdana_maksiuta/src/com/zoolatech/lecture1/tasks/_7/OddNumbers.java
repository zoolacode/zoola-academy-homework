package com.zoolatech.lecture1.tasks._7;

import java.util.Scanner;

/**
 * 7. Write a program that prints all odd numbers from N to 1. N should be read from the input.
 * Every number should be printed on the new line. Create two versions of the program:
 * one should use the for loop, second - the while loop.
 *         a. Input: 5
 *            Output: 5
 *                    3
 *                    1
 */
public class OddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        forLoopAllOddNumbers(number);
        whileLoopAllOddNumbers(number);
    }

    public static void forLoopAllOddNumbers(int number) {
        System.out.println("For loop: ");
        if (number >= 0) {
            for (int i = number; i > 0; i--) {
                if (i % 2 == 1) {
                    System.out.println(i);
                }
            }
        } else {
            for (int i = number; i < 1; i++) {
                if (i % 2 == -1) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void whileLoopAllOddNumbers(int number) {
        System.out.println("While loop: ");
        while (number > 0) {
            if (number % 2 == 1) {
                System.out.println(number);
            }
            number--;
        }
        while (number < 0) {
            if (number % 2 == -1) {
                System.out.println(number);
            }
            number++;
        }
    }
}

