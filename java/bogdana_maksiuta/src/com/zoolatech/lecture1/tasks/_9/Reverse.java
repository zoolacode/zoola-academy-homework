package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * 9. Write a program that accepts an integer value and outputs all its digits in the reverse order on a new line.
 a. Input: 12345
 *      Output: 5
 *              4
 *              3
 *              2
 *              1
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        reverseNumberWhileLoop(number);
        reverseNumberForLoop (number);
    }

    public static void reverseNumberWhileLoop (int number) {
        System.out.println("While loop: ");
        while (number != 0) {
            int lastNumber = number % 10;
            number = number/10;
            System.out.println(lastNumber);
        }
    }

    public static void reverseNumberForLoop (int number) {
        System.out.println("For loop: ");
        for (int i = number; i != 0 ; i /= 10) {
            int lastNumber = i % 10;
            System.out.println(lastNumber);
        }
    }
}

