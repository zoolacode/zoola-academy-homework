package com.zoolatech.lecture1.tasks._4;
import java.util.Scanner;

/**
 * Write a program that accepts a day of the week as an integer number (1 - Monday, 2 - Tuesday, …, 7 - Sunday)
 * and output “Need to go to work…” if the day is a weekday or “Sleeping…” if it’s a weekend.
 * Create two versions of the program: one should use the if-else statement, second - the conditional operator.
 */

public class Task4 {
    public static void main(String[] args) {
        // task solution code here
        Scanner sc = new Scanner(System.in);
        int numberofDay = sc.nextInt();
        dayTypeIf(numberofDay);
        dayTypeCond(numberofDay);
        //in this task, in my opinion, it is better to use an if-else statement, because the conditioal operator does not exclude the option of incorrect input
    }

    public static void dayTypeIf(int numberofDay){
        // function by if-else statement
        if(numberofDay>0 && numberofDay<6){

            System.out.println("Need to go to work…");

        } else if (numberofDay>5 && numberofDay<8) {

            System.out.println("Sleeping…");

        }else{
            System.out.println("Incorrect input!!!");
        }
    }


    public static void dayTypeCond(int numberofDay){
        // function by conditional operator
        System.out.println((numberofDay>0 && numberofDay<6)? "Need to go to work…": "Sleeping…");
    }

}
