package com.zoolatech.lecture1.tasks._7;

import java.util.Scanner;

/**
 * Write a program that prints all odd numbers from N to 1. N should be read from the input.
 * Every number should be printed on the new line.
 */

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printOdd(scanner.nextInt());
        System.out.println();
        printOdd_2(scanner.nextInt());
    }

    public static void printOdd(int N) {
        if (N % 2 == 0) {
            N--;
        }

        for (int i = N; i > 0; i -= 2) {
            System.out.println(i);
        }
    }

    public static void printOdd_2(int N) {
        while (N > 0) {
            if (N % 2 == 1) {
                System.out.println(N);
            }
            N--;
        }
    }
}
