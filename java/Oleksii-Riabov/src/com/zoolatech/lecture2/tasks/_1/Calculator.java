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

    private static double value;

    public static void main(String[] args) {
        System.out.println("Define first value");
        Calculator.value = getDoubleValue();
        System.out.println("First value is " + value + "\n");

        System.out.println("Define second value");
        double secondValue = getDoubleValue();
        System.out.println("Second value is " + secondValue+ "\n");

        Scanner input = new Scanner(System.in);

        showInstructions();

        String condition = "false";
        do {
            System.out.println("\nEnter evaluation sign to evaluate values");

            String line = input.nextLine().toLowerCase();
            switch (line) {
                case "+" -> evaluateNumbers(secondValue, '+');
                case "-" -> evaluateNumbers(secondValue, '-');
                case "*" -> evaluateNumbers(secondValue, '*');
                case "/" -> evaluateNumbers(secondValue, '/');
                case "1" -> System.out.println("First value is " + value);
                case "2" -> System.out.println("Second value is " + secondValue);
                case "i" -> showInstructions();
                case "exit" -> {
                    System.out.println("Program ends");
                    condition = "exit";
                }
                default -> {
                    System.out.println("Please enter valid value\n");
                    showInstructions();
                }
            }
        } while(!"exit".equals(condition));
    }

    public static double getDoubleValue() {
        String condition = "false";
        double returnValue = 0.0;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                returnValue = scanner.nextDouble();
                condition = "exit";
            } else {
                System.out.println("Enter numeric value");
            }
        } while(!"exit".equals(condition));
        return returnValue;
    }

    public static void showInstructions() {
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

    public static void evaluateNumbers(double number2, char c) {
        switch (c) {
            case '+' -> add(number2);
            case '-' -> subtract(number2);
            case '*' -> multiply(number2);
            case '/' -> divide(number2);
            default -> throw new IllegalArgumentException("Enter symbol of an operation");
        }
    }

    public static void add(double number2) {
        checkFractionalPart(value + number2);
    }

    public static void subtract(double number2) {
        checkFractionalPart(value - number2);
    }

    public static void multiply(double number2) {
        checkFractionalPart(value * number2);
    }

    public static void divide(double number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Divide by zero is not allowed!");
        } else {
            checkFractionalPart(value / number2);
        }
    }

    public static void checkFractionalPart(double number) {
        if (number % 1 == 0) {
            System.out.println((int) number);
        } else {
            System.out.println(number);
        }
    }
}
