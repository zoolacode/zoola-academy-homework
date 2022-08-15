package com.zoolatech.lecture1.tasks._7;

/* Write a program that prints all odd numbers from N to 1. N should be read from the input.
Every number should be printed on the new line. First version of the program:
use the for loop.*/

import java.util.Scanner;

public class Task_7a {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Input Number: ");
    int N = scanner.nextInt();
    for (int i = N; i > 0; i = i-2) {
        if (i % 2 != 0){
            System.out.println(i);
        }
        else {
            System.out.println(i-1);
        }
    }
    }
}
