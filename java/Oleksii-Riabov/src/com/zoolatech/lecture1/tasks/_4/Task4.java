package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number
 * (1 - Monday, 2 - Tuesday, …, 7 - Sunday) and output “Need to go to work…” if the day is a weekday
 * or “Sleeping…” if it’s a weekend. Create two versions of the program: one should use the if-else
 * statement, second - the conditional operator.
 */

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt()){
            ifElseMethod(scanner.nextInt());
            conditionalOperatorMethod(scanner.nextInt());
        } else {
            throw new IllegalArgumentException("Enter integer value");
        }
    }

    public static void ifElseMethod(int dayOfWeek) {
         if (dayOfWeek <= 0 || dayOfWeek >= 8) {
            throw new IllegalArgumentException("Enter value form 1 to 7");
        } else if(dayOfWeek == 6 || dayOfWeek == 7) {
            System.out.println("Sleeping...");
        } else {
            System.out.println("Need to go to work...");
        }
    }

    public static void conditionalOperatorMethod(int dayOfWeek) {
        if (dayOfWeek <= 0 || dayOfWeek >= 8) {
            throw new IllegalArgumentException("Enter value form 1 to 7");
        } else {
            System.out.println(dayOfWeek < 6 ? "Need to go to work..." : "Sleeping...");
        }
    }
}
