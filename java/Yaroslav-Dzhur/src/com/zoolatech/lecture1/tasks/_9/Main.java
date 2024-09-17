package com.zoolatech.lecture1.tasks._9;

/*
Write a program that accepts an integer value and outputs all its digits in the reverse order on a new line.
*/


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        int numberCreate;
        for (; number > 0; number /= 10) {
            numberCreate = number % 10;
            System.out.println(numberCreate);
        }
    }
}