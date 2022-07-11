package com.zoolatech.lecture1.tasks._5;

/**
 * Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 * Input: 2
 * 3
 * Output: 3
 * Input: 2
 * 2
 * Output: “Numbers are equal”
 */

public class TaskFive {

    public static void main(String[] args) {
        getLargerNumber(2, 3);
        getLargerNumber(3, 2);
        getLargerNumber(2, 2);
    }

    public static void getLargerNumber(int a, int b) {
        if (a == b)
            System.out.println("Numbers are equal");
        else System.out.println(a > b ? a : b);
    }
}
