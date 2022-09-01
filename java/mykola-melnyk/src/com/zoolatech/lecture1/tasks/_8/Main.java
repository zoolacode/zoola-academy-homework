package com.zoolatech.lecture1.tasks._8;

/**
 * Write a program that prints all numbers from 1 to N, that are divisible by 2, 3 or by both.
 * If a number is divisible by only 2 - print it and add in parentheses “(by 2)”,
 * if only by 3 - “(by 3)”, if by both numbers - “(by 2 and 3)”. Every number should be printed
 * on the new line. Create two versions of the program: one should use the for loop, second - the while loop.
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {

            if ((i % 2 == 0) && (i % 3 == 0)) {
                System.out.println(i + "(by 2 and 3)");
            } else if (i % 3 == 0) {
                System.out.println(i + "(by 3)");
            } else if  (i % 2 == 0) {
                System.out.println(i + "(by 2)");
            }

        }
    }
}
