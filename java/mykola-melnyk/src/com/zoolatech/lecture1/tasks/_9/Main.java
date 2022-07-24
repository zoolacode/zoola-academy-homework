package com.zoolatech.lecture1.tasks._9;

/**
 * Write a program that accepts an integer value and outputs all its digits in the reverse order on a new line.
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an integer:");
        int num = scanner.nextInt();
        while (num > 0) {
            int remainder = num % 10;
            System.out.println(remainder);
            num /= 10;
        }
    }
}
