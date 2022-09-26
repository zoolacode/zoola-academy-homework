package com.zoolatech.lecture1.tasks._4;

/*
Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
and output “Need to go to work…” if the day is a weekday or “Sleeping…” if it’s a weekend.
The conditional operator version.
*/

import java.util.Scanner;

public class conditionalOperator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the day of the week number (1-7): ");
        int dayOfWeek;
        while ((dayOfWeek = scan.nextInt()) < 1 || dayOfWeek > 7) {
            System.out.println("Enter the day of the week number (1-7) again: ");
        }
        System.out.println (dayOfWeek < 6 ? "Need to go to work…" : "Sleeping…");

    }
}
