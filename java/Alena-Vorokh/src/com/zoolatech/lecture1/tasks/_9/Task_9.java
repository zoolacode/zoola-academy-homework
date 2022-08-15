package com.zoolatech.lecture1.tasks._9;

/* Write a program that accepts an integer value and outputs all its digits in the reverse order on a new line.*/

import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input value: ");
        int N = scanner.nextInt();
        int i = 1;
        int j;
        int a = 10;
        int length = String.valueOf(N).length();
        while (i <= length ) {
            j = (N % a);
            N = (N - j)/a;
            System.out.println(j);
            i++;
        }

    }
}
