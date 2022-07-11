package com.zoolatech.lecture1.tasks._4;

/**
 * Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday or “Sleeping…” if it’s a weekend.
 * Create two versions of the program: one should use the if-else statement, second - the conditional operator.
 * Input: 3
 * Output: “Need to go to work…”
 * Explanation: 3 represents Wednesday, which is a weekday
 * Input: 6
 * Output: “Sleeping…”
 * Explanation: 6 represents Saturday, which is a weekend
 */
public class TaskFour {

    public static void main(String[] args) {
        getDayOfWeek1(3);
        getDayOfWeek1(6);
        getDayOfWeek1(0);
        System.out.println("--------------------");
        getDayOfWeek2(1);
        getDayOfWeek2(7);
        getDayOfWeek2(9);
    }

    public static void getDayOfWeek1(int day) {
        if (day > 0 && day < 8) {
            if (day <= 5) {
                System.out.println("Need to go to work…");
            } else {
                System.out.println("Sleeping…");
            }
        } else System.out.println("Days of the week are counted from 1 to 7");
    }

    public static void getDayOfWeek2(int day) {
        switch (day) {
            case 1, 2, 3, 4, 5 -> System.out.println("Need to go to work…");
            case 6, 7 -> System.out.println("Sleeping…");
            default -> System.out.println("Days of the week are counted from 1 to 7");
        }
    }
}
