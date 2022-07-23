package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;

/**
 * Define a class that represents a calculator. The class should provide methods
 * that accept another value and perform addition, subtraction, multiplication and
 * division operations on a value stored in a calculator instance. Divides by a
 * zero should be forbidden and ignored. The class should also provide a method to
 * get a current value. The class should work with both integer and double
 * numbers (ignore roundoff errors). Assume all operation results fit into the
 * range of values for a current value type.
 */

public class Calculator {
    double value;

    public Calculator(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public static void numbersEvaluationMethod(double number1, double number2, char c) {
        switch (c) {
            case '+' -> addition(number1, number2);
            case '-' -> subtraction(number1, number2);
            case '*' -> multiplication(number1, number2);
            case '/' -> division(number1, number2);
            default -> throw new IllegalArgumentException("Enter symbol of an operation");
        }
    }

    public static void fractionalPartCheck(double number) {
        if (number % 1 == 0) {
            System.out.println((int) number);
        } else {
            System.out.println(number);
        }
    }

    public static void addition (double number1, double number2) {
        fractionalPartCheck(number1 + number2);
    }

    public static void subtraction (double number1, double number2) {
        fractionalPartCheck(number1 - number2);
    }

    public static void multiplication (double number1, double number2) {
        fractionalPartCheck(number1 * number2);
    }

    public static void division (double number1, double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Divide by zero is not allowed!");
        } else {
            fractionalPartCheck(number1 / number2);
        }
    }

    public static double doubleValue() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Enter numeric value");
                continue;
            }
        }
    }

    public static void instructions() {
        System.out.println("""
                To add values enter "+"
                To subtract values enter "-"
                To multiply values enter "*"
                To divide values enter "/"
                To show first value enter "1"
                To show second value enter "2"
                To show instructions enter "i"
                To end program enter "exit"
                """);
    }

    public static void main(String[] args) {
        System.out.println("Define first value");
        Calculator calculator = new Calculator(doubleValue());
        System.out.println("First value is " + calculator.getValue()+ "\n");

        System.out.println("Define second value");
        double secondValue = doubleValue();
        System.out.println("Second value is " + secondValue+ "\n");

        Scanner input = new Scanner(System.in);

        instructions();
        outer:
        while (true) {
//            instructions();
            System.out.println("Enter evaluation sign to evaluate values");

            String line = input.nextLine().toLowerCase();
            switch (line) {
                case "+" -> {
                    numbersEvaluationMethod(calculator.getValue(), secondValue, '+');
                }
                case "-" -> {
                    numbersEvaluationMethod(calculator.getValue(), secondValue, '-');
                }
                case "*" -> {
                    numbersEvaluationMethod(calculator.getValue(), secondValue, '*');
                }
                case "/" -> {
                    numbersEvaluationMethod(calculator.getValue(), secondValue, '/');
                }
                case "1" -> System.out.println("First value is " + calculator.getValue());
                case "2" -> System.out.println("Second value is " + secondValue);
                case "i" -> instructions();
                case "exit" -> {
                    System.out.println("Program ends");
                    break outer;
                }
                default -> {
                    System.out.println("Please enter valid value\n");
                    instructions();
                }
            }
        }
    }
}
