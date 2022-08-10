package com.zoolatech.lecture1.tasks._3;

import java.util.Scanner;

/**
 * Write a program that accepts a double number and outputs only its fractional part
 * (all digits after the decimal point).
 * Note: it’s fine if the result will have a rounding error (0.8499999999999 instead of 0.85).
 * Input: 1.23
 * Output: 0.22999999999999998
 */
public class TaskThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number:");
        System.out.println(getFactorialPart(scanner.nextDouble()));
//        System.out.println(getFactorialPart2(scanner.nextDouble()));
    }

    public static double getFactorialPart(double input) {
        return input % 1;
    }

    public static double getFactorialPart2(double input) {
        return input - (int) input;
    }
}
