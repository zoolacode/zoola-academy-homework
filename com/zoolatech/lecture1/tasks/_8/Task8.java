package com.zoolatech.lecture1.tasks._8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that prints all numbers from 1 to N, that are divisible by 2, 3 or by both.
 * If a number is divisible by only 2 - print it and add in parentheses “(by 2)”,
 * if only by 3 - “(by 3)”, if by both numbers - “(by 2 and 3)”.
 * Every number should be printed on the new line.
 * Create two versions of the program: one should use the for loop, second - the while loop.
 **/
public class Task8 {
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    List<Integer> newarr = new ArrayList<Integer>();

    void checkDivision() {
        for (int i = 1; i <= number; i++) {
            newarr.add(i);
        }
        checkNumbers();
    }

    void checkDivisionWhileLoop() {
        int i = 1;
        while (i <= number) {
            newarr.add(i);
            i++;
        }
        checkNumbers();
    }

    void checkNumbers() {
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 2 == 0) {
                System.out.println(i + "(by 2 and 3)");
            } else if (i % 2 == 0) {
                System.out.println(i + "(by 2)");
            } else if (i % 3 == 0) {
                System.out.println(i + "(by 3)");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number");
        Task8 task8 = new Task8();
        task8.checkDivisionWhileLoop();
    }
}
