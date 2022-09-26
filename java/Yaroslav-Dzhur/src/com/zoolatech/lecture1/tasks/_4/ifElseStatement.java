package com.zoolatech.lecture1.tasks._4;

/*
Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
and output “Need to go to work…” if the day is a weekday or “Sleeping…” if it’s a weekend.
If-else statement version.
*/

import java.util.Scanner;

public class ifElseStatement {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the day of the week number (1-7): ");
        int dayOfWeek;
        while ((dayOfWeek = scan.nextInt()) < 1 || dayOfWeek > 7) {
            System.out.println("Enter the day of the week number (1-7) again: ");
        }
        if(dayOfWeek < 6)
            System.out.println("Need to go to work…");
        else
            System.out.println("Sleeping…");

    }
}
