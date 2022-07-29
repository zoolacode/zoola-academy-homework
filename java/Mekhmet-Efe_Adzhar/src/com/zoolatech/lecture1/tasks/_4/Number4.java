package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number
 * (1 - Monday, 2 - Tuesday, …, 7 - Sunday) and output “Need to go to work…”
 * if the day is a weekday or “Sleeping…” if it’s a weekend.
 * Create two versions of the program:
 * one should use the if-else statement, second - the conditional operator.
 */

public class Number4 {
    public static void main(String[] args) {
        Number4 number4 = new Number4();
        number4.ifElse();
        System.out.println("If-Else");
        number4.conditionalOperator();
        System.out.println("Conditional Operator");
    }

    //MARK: FIRST VERSION
    private void ifElse() {
        System.out.println("Choose a day of a week by number:");
        Scanner scanner = new Scanner(System.in);
        int dayOfAWeek = scanner.nextInt();
        if (containsDays(dayOfAWeek)) {
            System.out.println("Need to go to work...");
        } else {
            System.out.println("Sleeping...");
        }
    }

    //MARK: SECOND VERSION
    private void conditionalOperator() {
        System.out.println("Choose a day of a week by number:");
        Scanner scanner = new Scanner(System.in);
        int dayOfAWeek = scanner.nextInt();
        final var whatToDo = containsDays(dayOfAWeek) ? "Need to go to work..." : "Sleeping...";
        System.out.println(whatToDo);
    }

    //MARK: Private Method
    static private boolean containsDays(int day) {
        return (day >= 1 && day <= 5);
    }
}
/*
record RangeOfDays(int min, int max) {
    public boolean containsDays(int day) {
        return (day >= min && day <= max);
    }
  }
*/