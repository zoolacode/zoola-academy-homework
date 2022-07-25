package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 */

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1;
        int number2;

        if(scanner.hasNextInt()){
            number1 = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Enter integer value");
        }

        if(scanner.hasNextInt()){
            number2 = scanner.nextInt();
        } else {
            throw new IllegalArgumentException("Enter numeric value");
        }

        largerNumberOutputMethod(number1, number2);
    }

    public static void largerNumberOutputMethod(int number1, int number2) {
        System.out.println(number1 != number2 ? Math.max(number1, number2) : "Numbers are equal");
    }
}
