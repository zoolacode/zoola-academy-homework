package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * Write a program that accepts an integer value
 * and outputs all its digits in the reverse order on a new line.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        scanner.close();
        int i = inputNumber;
        while (i>0){
            System.out.println(i % 10);
            i/=10;
        }
    }
}
