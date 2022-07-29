package com.zoolatech.lecture1.tasks._3;

import java.util.Scanner;

/**Write a program that accepts a double number
 * and outputs only its fractional part (all digits after the decimal point).
 * Note: it’s fine if the result will have a rounding error (0.8499999999999 instead of 0.85).
 */

public class Number3 {
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        number3.calculate();
    }

    private void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number");
        double value = scanner.nextDouble();
        double factorialPart = value % 1;
        double integerPart = value - factorialPart;
        System.out.println("Integer Value: " + integerPart);
        System.out.println("Factorial Value: " + factorialPart);
    }
}