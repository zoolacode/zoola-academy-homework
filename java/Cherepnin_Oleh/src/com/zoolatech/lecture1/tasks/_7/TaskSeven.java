package com.zoolatech.lecture1.tasks._7;

import java.util.Scanner;

/**
 * Write a program that prints all odd numbers from N to 1. N should be read from the input.
 * Every number should be printed on the new line. Create two versions of the program:
 * one should use the for loop, second - the while loop.
 * Input: 5
 * Output: 5
 * 3
 * 1
 */
public class TaskSeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");
//        getOddsNumbers1(scanner.nextInt());
        getOddsNumbers2(scanner.nextInt());
    }

    public static void getOddsNumbers1(int number) {
        for (int i = number; i > 0; i--) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void getOddsNumbers2(int number) {
        while (number > 0) {
            if (number % 2 != 0) {
                System.out.println(number);
            } number--;
        }
    }
}