package com.zoolatech.lecture1.tasks._5;

import java.util.Scanner;

/**Write a program that accepts two numbers and outputs the larger value.
 * If numbers are equal - output “Numbers are equal”.
 */

public class Number5 {
    public static void main(String[] args) {
        Number5 number5 = new Number5();
        number5.greaterNumber();
    }

    private void greaterNumber() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type first number:");
        int number1 = scanner.nextInt();
        System.out.println("Type second number:");
        int number2 = scanner.nextInt();

                    //if number1 > number2 : First...  else if number1 == number2: "Equal"...   else: Second...
        // result = number1 > number2 ? "First value is greater" : number1 == number2 ? "Equal" : "Second value is greater";

        String result;
        if(number1 > number2) {
            result = "First value is greater";
        }
        else if(number1 < number2) {
            result = "Second value is greater";
        } else {
            result = "Equal";
        }
        System.out.println(result);
    }
}