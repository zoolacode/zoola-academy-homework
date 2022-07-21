package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**
 * 5. Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 *         a. Input: 2
 *            3
 *            Output: 3
 *         b. Input: 2
 *            2
 *            Output: “Numbers are equal”
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println("Enter 2 numbers: ");
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        compareNumbers(firstNumber, secondNumber);
    }
    public static void compareNumbers (int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            System.out.println("The largest number is: " + firstNumber);
        } else if (firstNumber == secondNumber) {
            System.out.println("The numbers are equal");
        } else {
            System.out.println("The largest number is: " + secondNumber);
        }
    }
}
