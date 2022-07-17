package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**Write a program that accepts a day of the week as an integer number
 *  (1 - Monday, 2 - Tuesday, …, 7 - Sunday) and output “Need to go to work…”
 *  if the day is a weekday or “Sleeping…” if it’s a weekend.
 *  Create two versions of the program:
 *  one should use the if-else statement, second - the conditional operator.
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
        int dayOfAWeek;
        RangeOfDays range = new RangeOfDays(1, 5);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a day of a week by number:");
        dayOfAWeek = scanner.nextInt();

        if (range.containsDays(dayOfAWeek)) {
            System.out.println("Need to go to work...");
        } else {
            System.out.println("Sleeping...");
        }
    }

    //MARK: SECOND VERSION
    private void conditionalOperator() {
        int dayOfAWeek;
        RangeOfDays range = new RangeOfDays(1, 5);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a day of a week by number:");
        dayOfAWeek = scanner.nextInt();
        final var whatToDo = range.containsDays(dayOfAWeek) ? "Need to go to work..." : "Sleeping...";
        System.out.println(whatToDo);
    }
}

class RangeOfDays {
    final int min;
    final int max;

    RangeOfDays(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean containsDays(int day) {
        return (day >= min && day <= max);
    }
}