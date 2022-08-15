package com.zoolatech.lecture1.tasks._4;

/*Write a program that accepts a day of the week as an integer number and output “Need to go to work…”
if the day is a weekday or “Sleeping…” if it’s a weekend.
Fist version - use the if-else statement.*/

import java.util.Scanner;

public class Task_4a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Number of the day of the week: ");
        int numberOfTheDay = scanner.nextInt();
        if (numberOfTheDay >=1 && numberOfTheDay < 6){
            System.out.println("Need to go to work..." );
        } else if (numberOfTheDay >=6 && numberOfTheDay <=7){
            System.out.println("Sleeping..." );
        } else {
            System.out.println("Day of the week not found" );
        }

    }

}

