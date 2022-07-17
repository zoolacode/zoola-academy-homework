package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**Write a program that accepts two numbers and outputs the larger number.
 * If numbers are equal - output “Numbers are equal”.
 */

public class Number5 {
    public static void main(String[] args) {
        Number5 number5 = new Number5();
        number5.greaterNumber();
    }

    private void greaterNumber() {
        int number1;
        int number2;
        String result;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type first number:");
        number1 = scanner.nextInt();
        System.out.println("Type second number:");
        number2 = scanner.nextInt();

        result = number1 > number2 ? "First number is greater" : number1 == number2 ? "Equal" : "Second number is greater";

        System.out.println(result);
    }
}