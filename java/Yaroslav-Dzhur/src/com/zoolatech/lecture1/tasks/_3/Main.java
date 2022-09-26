package com.zoolatech.lecture1.tasks._3;

/*
Write a program that accepts a double number and outputs only its fractional part (all digits after the decimal point).
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter a double number: ");
        double doubleNumber = scanner.nextDouble();

        double fractionalPart = doubleNumber % 1;
        System.out.println("Fractional part: " + fractionalPart);
    }
}
