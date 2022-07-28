package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;

/**
 * Define a class that represents a calculator.
 * The class should provide methods that accept another value and perform addition, subtraction,
 * multiplication and division operations on a value stored in a calculator instance.
 * Divides by a zero should be forbidden and ignored. The class should also provide a method to get a current value.
 * The class should work with both integer and double numbers (ignore roundoff errors).
 * Assume all operation results fit into the range of values for a current value type.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double firstNumber = inputNumber();

        calculator.setCurrentValue(firstNumber);
        char symbol = inputSymbol();

        while (symbol != '!') {
            double secondNumber = inputNumber();
            switch (symbol) {
                case '+' -> calculator.addition(secondNumber);
                case '-' -> calculator.subtraction(secondNumber);
                case '*' -> calculator.multiplication(secondNumber);
                case '/' -> calculator.division(secondNumber);
                default -> System.out.println("Invalid symbol");
            }
            System.out.println(calculator.getCurrentValue());
            System.out.println("'!' - exit");
            symbol = inputSymbol();
        }
    }

    public static double inputNumber() {
        System.out.println("Please enter a number : ");
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("Invalid value. Try another number : ");
            scanner.next();
            number = inputNumber();
        }
        return number;
    }

    public static char inputSymbol() {
        System.out.println("Please enter a symbol of arithmetic operation : ");
        char symbol = scanner.next().charAt(0);
        if (symbol != '/' && symbol != '+' && symbol != '-' && symbol != '*' && symbol != '!') {
            System.out.println("Invalid value");
            symbol = inputSymbol();
        }
        return symbol;
    }
}
