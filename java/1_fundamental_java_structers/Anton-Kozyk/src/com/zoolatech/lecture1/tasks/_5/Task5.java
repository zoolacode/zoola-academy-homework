package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and outputs the larger number. If numbers
 * are equal - output “Numbers are equal”.
 */

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printLarger(scanner.nextInt(), scanner.nextInt());

    }

    public static void printLarger(int a, int b) {
        if (a == b)
            System.out.println("Numbers are equal");
        else
            System.out.println(Math.max(a, b));
    }
}

