package com.zoolatech.java.solomiia_tymoshchuk.src.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday) and output
 * “Need to go to work…” if the day is a weekday or “Sleeping…”
 * if it’s a weekend. Create two versions of the program:
 * one should use the if-else statement, second - the conditional operator.
 **/
public class Task4 {
    int[] numbers = new int[]{1, 2, 3, 4, 5};

    public String defineMood() throws NumberOutOfRangeException {
        String statement = null;
        System.out.println("Enter the digit");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number>7 || number<1) {
            throw new NumberOutOfRangeException("Numbers is out of required range");
        }
        for (Integer day : numbers) {
            if (number == day) {
                statement = "Need to go to work…";
                break;
            } else {
                statement = "Sleeping…";
            }

        }
        return statement;
    }

    public static void main(String[] args) throws NumberOutOfRangeException {
        Task4 task4 = new Task4();
        System.out.println(task4.defineMood());
    }
}
