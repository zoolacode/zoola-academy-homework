package com.zoolatech.lecture1.tasks._7;

import java.util.Scanner;

/**
 * Write a program that prints all odd numbers from N to 1.
 * N should be read from the input.
 * Every number should be printed on the new line.
 * Create two versions of the program: one should use the for loop, second - the while loop.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        scanner.close();
        if (inputNumber % 2 == 0) {
            for (int i = inputNumber - 1; i >= 1; i-=2) {
                System.out.println(i);
            }
        } else {
            for (int i = inputNumber; i >= 1; i-=2) {
                System.out.println(i);
            }
        }
//        int i = inputNumber;
//        while(i>=1){
//            if (i % 2 != 0){
//                System.out.println(i);
//            }
//            i--;
//        }
    }
}
