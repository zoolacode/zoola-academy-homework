package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday or “Sleeping…” if it’s a weekend.
 * Create two versions of the program: one should use the if-else statement, second - the conditional operator.
 * a. Input: 3
 * Output: “Need to go to work…”
 * Explanation: 3 represents Wednesday, which is a weekday
 * b. Input: 6
 * Output: “Sleeping…”
 * Explanation: 6 represents Saturday, which is a weekend
 */
public class DefineDayOfTheWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the day of the week: \nWhere \"1\" is Monday \"7\" is Sunday");
        int numberOfTheDay = scanner.nextInt();
        ifElseDefiner(numberOfTheDay);
        System.out.println(conditionalOperatorDefiner(numberOfTheDay));
    }

    public static void ifElseDefiner(int numberOfTheDay) {
        if (numberOfTheDay >= 1 && numberOfTheDay <= 5) {
            System.out.println("Need to go to work...");
        } else if (numberOfTheDay >= 6 && numberOfTheDay <= 7) {
            System.out.println("Sleeping…");
        } else {
            throw new IllegalArgumentException("Wrong number " + numberOfTheDay);
        }
    }

    public static String conditionalOperatorDefiner(int numberOfTheDay) {
        return numberOfTheDay >= 1 && numberOfTheDay <= 5 ? "Need to go to work..." : "Sleeping…";
    }
}
