package com.zoolatech.lecture1.tasks._7;

/* Write a program that prints all odd numbers from N to 1. N should be read from the input.
Every number should be printed on the new line. Second version of the program:
use the while loop.*/

import java.util.Scanner;

public class Task_7b {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Number: ");
        int N = scanner.nextInt();
        while (N % 2 != 0 && N > 0){
            System.out.println(N);
            N = N - 2;
            }
        while (N % 2 == 0 && N > 0){
            N = N - 2;
            System.out.println(N + 1);
        }
        }
    }


