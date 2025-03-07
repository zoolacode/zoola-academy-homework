package com.zoolatech.lecture1.tasks._4;

import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number
 * (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday
 * or “Sleeping…” if it’s a weekend.
 * Create two versions of the program: one should use the if-else statement,
 * second - the conditional operator.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        scanner.close();
        if (inputNumber <=5){
            System.out.println("Need to go to work…");
        }
        else {
            System.out.println("Sleeping…");
        }

//        String result = input<=5 ? "Need to go to work…":"Sleeping…";
//        System.out.println(result);
    }
}
