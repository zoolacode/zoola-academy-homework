package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number (1 - Monday, 2 -
 * Tuesday, …, 7 - Sunday) and output “Need to go to work…” if the day is a weekday or
 * “Sleeping…” if it’s a weekend.
 */

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();

        if (day > 0 && day < 8) {
            isItWeekend_1(day);
            System.out.println("--------------------");
            isItWeekend_2(day);
        } else {
            System.out.println("Wrong day...");
        }
    }

    public static void isItWeekend_1(int day) {
        if (day > 0 && day < 6) {
            System.out.println("Need to go to work...");
        } else {
            System.out.println("Sleeping...");
        }
    }

    public static void isItWeekend_2(int day) {
        System.out.println(day < 6 ? "Need to go to work..." : "Sleeping...");
    }
}
