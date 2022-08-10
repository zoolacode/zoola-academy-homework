package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and outputs the larger number. If numbers
 * are equal - output “Numbers are equal”.
 */

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        if (firstNumber == secondNumber) {
            System.out.println("Numbers are equal");
        } else {
            System.out.println("Result of the first method: " +
                    printLarger1(firstNumber, secondNumber));

            System.out.println("Result of the second method: " +
                    printLarger2(firstNumber, secondNumber));
        }
    }

    public static int printLarger1(int firstNumber, int secondNumber) {
        return Math.max(firstNumber, secondNumber);
    }

    public static int printLarger2(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber ? firstNumber : secondNumber;
    }
}

