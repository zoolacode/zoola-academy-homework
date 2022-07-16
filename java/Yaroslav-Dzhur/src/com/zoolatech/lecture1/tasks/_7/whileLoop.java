package com.zoolatech.lecture1.tasks._7;

/*
Write a program that prints all odd numbers from N to 1.
N should be read from the input. Every number should be printed on the new line.
The while loop version.
*/


import java.util.Scanner;

public class whileLoop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        // read a int number
        System.out.println("Enter number: ");
        int number = scanner.nextInt();

        while (number>0){
            if (number % 2 != 0){
                System.out.println(number);
            }
            number--;

        }
    }
}
