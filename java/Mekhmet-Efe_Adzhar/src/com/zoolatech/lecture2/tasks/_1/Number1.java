package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;
import java.lang.ArithmeticException;

/*Define a class that represents a calculator.
 *  The class should provide methods that accept another value and perform
 *  addition, subtraction, multiplication and division operations
 *  on a value stored in a calculator instance.
 *  Divides by a zero should be forbidden and ignored.
 *  The class should also provide a method to get a current value.
 *  The class should work with both integer and double numbers (ignore roundoff errors).
 *  Assume all operation results fit into the range of values for a current value type.
 */

public class Number1 {
    static Scanner scanner = new Scanner(System.in);
    static Calculator calculator;

    public static void main(String[] args) {

        System.out.println("1. Start");
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextInt() == 1) {
            calculation();
        } else {
            throw new IllegalArgumentException("Unknown" + scanner.nextInt());
        }
    }

    private static void calculation() {
        System.out.println("Input first number:");
        calculator = new Calculator(scanner.nextDouble());
        System.out.println("Input second double");
        double numberTwoDouble = scanner.nextDouble();
        operations(numberTwoDouble);
    }

    private static void operations(double numberTwo) {
        System.out.println("Input operation:");
        char operation = scanner.next().charAt(0);
        switch (operation) {
            case '+' -> calculator.addition(numberTwo);
            case '-' -> calculator.subtraction(numberTwo);
            case '*' -> calculator.multiplication(numberTwo);
            case '/' -> calculator.division(numberTwo);
            default -> System.out.println("ERROR");
        }
    }
}


class Calculator {

    private double numberOne;

    public Calculator(double numberOne) {
        this.numberOne = numberOne;
    }

    public void addition(double numberTwoDouble) {
        numberOne += numberTwoDouble;
        System.out.println("Result:" + " " + numberOne);
    }

    public void subtraction(double numberTwoDouble) {
        numberOne -= numberTwoDouble;
        System.out.println("Result:" + " " + numberOne);
    }

    public void multiplication(double numberTwoDouble) {
        numberOne *= numberTwoDouble;
        System.out.println("Result:" + " " + numberOne);
    }

    public void division(double numberTwoDouble) {
        if (numberTwoDouble == 0.0) {
            System.out.println("Zero is not dividable\n");
        } else {
            try {
                numberOne /= numberTwoDouble;
                System.out.println("Result:" + " " + numberOne);
            } catch (ArithmeticException error) {
                System.out.println("Zero is not dividable\n");
            }
        }
    }
}