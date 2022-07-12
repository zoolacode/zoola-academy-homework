package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * Write a program that accepts an integer value
 * and outputs all its digits in the reverse order on a new line.
 */

public class Number9 {
    public static void main(String[] args) {
        Number9 number9 = new Number9();
        number9.reverseInt();

    }

    private void reverseInt() {
        Scanner scanner = new Scanner(System.in);
        int integer;
        int revert = 0;
        System.out.println("Intput number:");
        integer = scanner.nextInt();

        while (integer != 0) {
            revert = revert * 10 + integer % 10;
            integer = integer / 10;
        }
        System.out.print("Result is:" + " " + revert);
    }
}