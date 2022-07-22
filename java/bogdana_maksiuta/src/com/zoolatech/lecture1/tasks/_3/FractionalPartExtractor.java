package com.zoolatech.lecture1.tasks._3;

import java.util.Scanner;

/**
 *     3. Write a program that accepts a double number and outputs only its fractional part
 *     (all digits after the decimal point). Note: it’s fine if the result will have a rounding error
 *     (0.8499999999999 instead of 0.85).
 *             a. Input: 1.23
 *                Output: 0.22999999999999998
 */
public class FractionalPartExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");

        if (scanner.hasNextDouble()) {
            double inputNumber = scanner.nextDouble();
            fractionalPart(inputNumber);
        } else {
            throw new IllegalArgumentException("Unknown number");
        }
    }

    public static void fractionalPart (double inputNumber) {
        int inputNumberInteger = (int) inputNumber;
        double fractionalPartInputNumber = inputNumber - inputNumberInteger;
        System.out.println(fractionalPartInputNumber);
    }
}

