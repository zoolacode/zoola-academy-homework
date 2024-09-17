package com.zoolatech.lecture1.tasks._8;

/*
Write a program that prints all numbers from 1 to N, that are divisible by 2, 3 or by both.
If a number is divisible by only 2 - print it and add in parentheses “(by 2)”,
if only by 3 - “(by 3)”, if by both numbers - “(by 2 and 3)”. Every number should be printed on the new line.
The while loop version.
*/


import java.util.Scanner;

public class whileDivisible {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        int i = 1;

        while (i <= number){
            if (i % 2 == 0 && i % 3 == 0){
                System.out.println(i + " (by 2 and 3)");
            }
            else if (i % 2 == 0){
                System.out.println(i + " (by 2)");
            }
            else if (i % 3 == 0){
                System.out.println(i + " (by 3)");
            }
            i++;

        }
    }
}
