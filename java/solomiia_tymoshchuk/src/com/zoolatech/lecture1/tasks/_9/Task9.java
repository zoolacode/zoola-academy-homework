package com.zoolatech.lecture1.tasks._9;

import java.util.Scanner;

/**
 * Write a program that accepts an integer value and
 * outputs all its digits in the reverse order on a new line.
 **/
public class Task9 {
    int number;

    public Task9(int number) {
        this.number = number;
    }

    void reversedInput() {
        String string = Integer.toString(number);
        char[] ch = string.toCharArray();

        for (int i = ch.length - 1; i >= 0; i--) {
            char newChar = ch[i];
            System.out.println(newChar);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("Enter number");
        Task9 task9 = new Task9(number);
        task9.reversedInput();
    }
}
