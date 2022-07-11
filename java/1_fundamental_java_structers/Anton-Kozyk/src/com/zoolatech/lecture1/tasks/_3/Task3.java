package com.zoolatech.lecture1.tasks._3;

import java.util.Scanner;

/**
 * Write a program that accepts a double number and outputs only its fractional part (all
 * digits after the decimal point).
 */

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printFractionalPart(scanner.nextDouble());
    }

    public static void printFractionalPart (double a) {
        System.out.println("Fractional part: " + (a - (int) a));
    }


}
