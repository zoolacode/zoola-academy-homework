package com.zoolatech.lecture1.tasks._3;

import java.util.Scanner;

/**
 * Write a program that accepts a double number and outputs only its
 * fractional part (all digits after the decimal point).
 */

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextFloat()){
            fractionalPart(scanner.nextFloat());
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }
    }

    static void fractionalPart(double number) {
        System.out.println(number % 1);
    }
}
