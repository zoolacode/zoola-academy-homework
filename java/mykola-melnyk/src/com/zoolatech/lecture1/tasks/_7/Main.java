package com.zoolatech.lecture1.tasks._7;

/**
 * Write a program that prints all odd numbers from N to 1.
 * N should be read from the input. Every number should be printed on the new line.
 * Create two versions of the program: one should use the for loop, second - the while loop.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input an integer:");
        int num = scanner.nextInt();
        if (num % 2 == 0) {
            num -= 1;
        }
        for (int i = num; i > 0; i -= 2) {
            System.out.println(i);
        }
    }
}
