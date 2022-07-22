package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    public void processOfCalculation() {
        double firstNumber = inputNumber();
        char symbol = inputSymbol();
        double secondNumber = inputNumber();

        switch (symbol) {
            case '+' -> addition(firstNumber, secondNumber);
            case '-' -> subtraction(firstNumber, secondNumber);
            case '*' -> multiplication(firstNumber, secondNumber);
            case '/' -> division(firstNumber, secondNumber);
            default -> System.out.println("Invalid symbol");
        }
    }

    public double inputNumber() {
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

    public char inputSymbol() {
        System.out.println("Please enter a symbol of arithmetic operation : ");
        char symbol = scanner.next().charAt(0);
        if (symbol != '/' && symbol != '+' && symbol != '-' && symbol != '*') {
            System.out.println("Invalid value");
            symbol = inputSymbol();
        }
        return symbol;
    }

    public void addition(double firstNumber, double secondNumber) {
        double resultOfAddition = firstNumber + secondNumber;
        System.out.println(firstNumber + " + " + secondNumber + " = " + resultOfAddition);
    }

    public void subtraction(double firstNumber, double secondNumber) {
        double resultOfSubtraction = firstNumber - secondNumber;
        System.out.println(firstNumber + " - " + secondNumber + " = " + resultOfSubtraction);
    }

    public void multiplication(double firstNumber, double secondNumber) {
        double resultOfMultiplication = firstNumber * secondNumber;
        System.out.println(firstNumber + " * " + secondNumber + " = " + resultOfMultiplication);
    }

    public void division(double firstNumber, double secondNumber) {
        double resultOfDivision;
        if (secondNumber == 0) {
            System.out.println("Are you mad? Cannot divide by 0");
        } else {
            resultOfDivision = firstNumber / secondNumber;
            System.out.println(firstNumber + " / " + secondNumber + " = " + resultOfDivision);
        }
    }
}

