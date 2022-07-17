package com.zoolatech.lecture1.tasks._8;

import java.util.Scanner;

/**
 * Write a program that prints all numbers from 1 to N,
 * that are divisible by 2, 3 or by both.
 * If a number is divisible by only 2 - print it and add in parentheses “(by 2)”,
 * if only by 3 - “(by 3)”, if by both numbers - “(by 2 and 3)”.
 * Every number should be printed on the new line.
 * Create two versions of the program:
 * one should use the for loop, second - the while loop.
 */

public class Number8 {

    public static void main(String[] args) {
        Number8 number8 = new Number8();
        //number8.divideNumberForLoop();
        number8.divideNumberWhileLoop();
    }

    private void divideNumberForLoop() {
        Scanner scanner = new Scanner(System.in);
        int integer;
        System.out.println("Intput number:");
        integer = scanner.nextInt();

        for (int i = 2; i <= integer; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                System.out.println(i + " " + "(by 2 & 3)");
            } else {
                if (i % 2 == 0) {
                    System.out.println(i + " " + "(by 2)");
                }
                if (i % 2 != 0) {
                    System.out.println(i + " " + "(by 3)");
                }
            }
        }
    }

    private void divideNumberWhileLoop() {
        Scanner scanner = new Scanner(System.in);
        int integer;
        int i = 2;
        String result;
        System.out.println("Intput number:");
        integer = scanner.nextInt();

        while (i <= integer) {
            result = i % 2 == 0 && i % 3 == 0 ? i + " " + "(by 2 & 3)" : i % 2 == 0 ? i + " " + "(by 2)" : i + " " + "(by 3)";
            System.out.println(result);
            i += 1;
        }
    }
}