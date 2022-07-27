package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * Write a program that accepts an integer value and outputs all its digits in the reverse order on a new line.
 * Input: 12345
 * Output: 5
 * 4
 * 3
 * 2
 * 1
 */
public class TaskNine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");
        reverseInteger(scanner.nextInt());
    }

    public static void reverseInteger(Integer integer) {
        String[] split = integer.toString().split("");

        for (int i = split.length - 1; i >= 0; i--) {
            System.out.println(split[i]);
        }
    }
}
