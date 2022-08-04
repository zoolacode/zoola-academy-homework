package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**
 * Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 * Input: 2
 * 3
 * Output: 3
 * Input: 2
 * 2
 * Output: “Numbers are equal”
 */

public class TaskFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a first number:");
        int a = scanner.nextInt();
        System.out.println("Input a second number:");
        int b = scanner.nextInt();
        getLargerNumber(a, b);
    }

    public static void getLargerNumber(int a, int b) {
        if (a == b) {
            System.out.println("Numbers are equal");
        } else {
            System.out.println(a > b ? a : b);
        }
    }
}
