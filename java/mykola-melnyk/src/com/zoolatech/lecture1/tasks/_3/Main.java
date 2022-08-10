package com.zoolatech.lecture1.tasks._3;

/**
 * Write a program that accepts a double number and outputs only
 * its fractional part (all digits after the decimal point).
 * Note: it’s fine if the result will have a rounding error
 * (0.8499999999999 instead of 0.85).
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a double number:");
        double value = scanner.nextDouble();
        double fractionalPart = value % 1;
        /*double integerPart = Math.floor(value);
        double fractionalPart = value - integerPart;*/
        System.out.println("A fractional part is: " + fractionalPart);
    }
}
