package com.zoolatech.lecture1.tasks._4;
import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday or “Sleeping…” if it’s a weekend.
 * Create two versions of the program: one should use the if-else statement, second - the conditional operator.
 */

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfDays = sc.nextInt();
        dayTypeByIfElseStatement(numberOfDays);
        dayTypeCond(numberOfDays);
        //in this task, in my opinion, it is better to use an if-else statement, because the conditioal operator does not exclude the option of incorrect input
    }

    public static void dayTypeByIfElseStatement(int numberOfDays){
        if(numberOfDays>0 && numberOfDays<6){
            System.out.println("Need to go to work…");
        } else if (numberOfDays>5 && numberOfDays<8) {
            System.out.println("Sleeping…");
        }else{
            System.out.println("Incorrect input!!!");
        }
    }


    public static void dayTypeCond(int numberOfDays){
        System.out.println((numberOfDays>0 && numberOfDays<6)? "Need to go to work…": "Sleeping…");
    }
}
