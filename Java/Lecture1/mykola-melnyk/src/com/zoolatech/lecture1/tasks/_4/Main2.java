package com.zoolatech.lecture1.tasks._4;

/**
 * Write a program that accepts a day of the week
 * as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday or
 * “Sleeping…” if it’s a weekend. Create two versions of the program:
 * one should use the if-else statement, second - the conditional operator.
 */

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter week day number:");
        int day = scanner.nextInt();
        if ((1 <= day) && (day < 6)) {
            System.out.println("Need to go to work…");
        } else if (day >= 6 && day < 8) {
            System.out.println("Sleeping…");
        } else {
            System.out.println("Error");
        }


    }
}
