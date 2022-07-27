package com.zoolatech.lecture1.tasks._8;

import java.util.Scanner;

/**
 * 8. Write a program that prints all numbers from 1 to N, that are divisible by 2, 3 or by both.
 * If a number is divisible by only 2 - print it and add in parentheses “(by 2)”, if only by 3 - “(by 3)”,
 * if by both numbers - “(by 2 and 3)”. Every number should be printed on the new line.
 * Create two versions of the program: one should use the for loop, second - the while loop.
 * a. Input: 12
 * Output: 2 (by 2)
 *         3 (by 3)
 *         4 (by 2)
 *         6 (by 2 and 3)
 *         8 (by 2)
 *         9 (by 3)
 *         10 (by 2)
 *         12 (by 2 and 3)
 */
public class CheckDivideIsPossible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        divisionForLoop(number);
        divisionWhileLoop(number);
    }

    public static void divisionForLoop(int number) {
        System.out.println("For loop: ");
        if (number >= 0) {
            for (int i = 1; i <= number; i++) {
                divisionBy2By3(i);
            }
        } else {
            throw new IllegalArgumentException("Negative number");
        }
    }

    public static void divisionWhileLoop(int number) {
        System.out.println("\nWhile loop: ");
        int startNumber = 1;

        if (number >= 0) {
            while (startNumber <= number) {
                divisionBy2By3(startNumber);
                startNumber++;
            }
        } else {
            throw new IllegalArgumentException("Negative number");
        }
    }

    public static void divisionBy2By3(int i) {
        if (i % 2 == 0 && i % 3 == 0) {
            System.out.println(i + " (by 2 and 3)");
        } else if (i % 2 == 0) {
            System.out.println(i + " (by 2)");
        } else if (i % 3 == 0) {
            System.out.println(i + " (by 3)");
        }
    }
}
