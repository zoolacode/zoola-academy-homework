package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * Write a program that accepts an integer value and outputs all its digits in the reverse
 * order on a new line.
 */

public class Task9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt()){
            digitsInReverseOrder(scanner.nextInt());
        } else {
            throw new IllegalArgumentException("Enter integer value");
        }
    }

    public static void digitsInReverseOrder(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Enter positive number");
        }

        for(; number != 0; number = number/10) {
            System.out.println(number % 10);
        }
    }
}
