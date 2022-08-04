package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * Write a program that accepts an integer value and outputs all its digits in the reverse
 * order on a new line.
 */

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        digits(scanner.nextInt());
    }

    public static void digits(int num) {
        while (num > 0) {
            System.out.println(num % 10);
            num /= 10;
        }
    }
}
