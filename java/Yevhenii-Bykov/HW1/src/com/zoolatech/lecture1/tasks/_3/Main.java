package com.zoolatech.lecture1.tasks._3;

import java.util.Scanner;

/**
 * Write a program that accepts a double number
 * and outputs only its fractional part (all digits after the decimal point).
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputNumber = scanner.nextFloat();
        int truncateInputNumber = (int) inputNumber;
        double result = inputNumber - truncateInputNumber;
        System.out.println(result);
        scanner.close();
    }
}
