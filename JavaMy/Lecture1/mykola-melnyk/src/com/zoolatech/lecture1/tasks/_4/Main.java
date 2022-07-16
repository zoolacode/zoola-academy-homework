package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week
 * as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday or
 * “Sleeping…” if it’s a weekend. Create two versions of the program:
 * one should use the if-else statement, second - the conditional operator.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter week day number:");
        // Reading a value
        int day = scanner.nextInt();
        String msg = ((1 <= day) && (day < 6)) ?
                ("Need to go to work…") :
                ((day > 8) ? ("Error") : ("Sleeping…")
                );
        System.out.println(msg);
    }
}
