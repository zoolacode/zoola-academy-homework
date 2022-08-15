package com.zoolatech.lecture1.tasks._4;

/*Write a program that accepts a day of the week as an integer number and output “Need to go to work…”
if the day is a weekday or “Sleeping…” if it’s a weekend.
Second version - the conditional operator.*/

import java.util.Scanner;

public class Task_4b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Number of the day of the week: ");
        int numberOfTheDay = scanner.nextInt();
        System.out.println(numberOfTheDay >=1 && numberOfTheDay < 6 ? "Need to go to work..." : numberOfTheDay < 8 ? "Sleeping...":"Day of the week not found");

        }
}
