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
     static Calculator calculator = new Calculator(0);

    public static void main(String[] args) {

        System.out.println("1. Start");
        Scanner scanner = new Scanner(System.in);

        if (scanner.nextInt() == 1) {
            calculations();
        } else {
            throw new IllegalArgumentException("Unknown" + scanner.nextInt());
        }
    }

    public static void calculations() {
        System.out.println("Input first number:");
        if (scanner.hasNextInt()) {
            integerCalc();
        } else if (scanner.hasNextDouble()) {
            doubleCalc();
        }
    }

    private static void integerCalc() {
        calculator = new Calculator(scanner.nextInt());
        calculator.setInteger(true);
        System.out.println("Input second integer");
        int numberTwo = scanner.nextInt();
        char operation = scanner.next().charAt(0);
        switch (operation) {
            case '+' -> calculator.addition(numberTwo);
            case '-' -> calculator.subtraction(numberTwo);
            case '*' -> calculator.multiplication(numberTwo);
            case '/' -> calculator.division(numberTwo);
            default -> System.out.println("Error");
        }
    }

    private static void doubleCalc() {
        calculator = new Calculator(scanner.nextDouble());
        calculator.setInteger(false);
        System.out.println("Input second double");
        double numberTwoDouble = scanner.nextDouble();
        char operation = scanner.next().charAt(0);
        switch (operation) {
            case '+' -> calculator.addition(numberTwoDouble);
            case '-' -> calculator.subtraction(numberTwoDouble);
            case '*' -> calculator.multiplication(numberTwoDouble);
            case '/' -> calculator.division(numberTwoDouble);
            default -> System.out.println("ERROR");
        }
    }
}


class Calculator {

    private boolean isInteger;
    private final double numberOne;

    public double getNumberOne() {
        return numberOne;
    }

    public Calculator(double numberOne) {
        this.numberOne = numberOne;
    }

    public void setInteger(boolean integer) {
        isInteger = integer;
    }

    public void addition(double numberTwoDouble) {
        if (isInteger) {
            int numberOneInt = (int)numberOne;
            int numberTwoInt = (int) numberTwoDouble;
            int calculationForInteger = numberOneInt + numberTwoInt;
            System.out.println("Result:" + " " + calculationForInteger);
        } else {
            double calculationForDouble = numberOne + numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
    }

    public void subtraction(double numberTwoDouble) {
        if (isInteger) {
            int numberOneInt = (int) numberOne;
            int numberTwoInt = (int) numberTwoDouble;

            int calculationForInteger = numberOneInt - numberTwoInt;
            System.out.println("Result:" + " " + calculationForInteger);
        } else {
            double calculationForDouble = numberOne - numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
    }

    public void multiplication(double numberTwoDouble) {
        if (isInteger) {
            int numberOneInt = (int) numberOne;
            int numberTwoInt = (int) numberTwoDouble;
            int calculationForInteger = numberOneInt * numberTwoInt;
            System.out.println("Result:" + " " + calculationForInteger);
        } else {
            double calculationForDouble = numberOne * numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
    }

    public void division(double numberTwoDouble) {
        int numberOneInt = (int) numberOne;
        int numberTwoInt = (int) numberTwoDouble;
        if (!isInteger) {
            if (numberTwoDouble == 0.0) {
                System.out.println("Zero is not dividable\n");
            } else {
                try {
                    double calculationForDouble = numberOne / numberTwoDouble;
                    System.out.println("Result:" + " " + calculationForDouble);
                } catch (ArithmeticException error) {
                    System.out.println("Zero is not dividable\n");
                }
            }
        } else {
            if (numberTwoInt == 0) {
                System.out.println("Zero is not dividable\n");
            } else {
                try {
                    int calculationForInteger = numberOneInt / numberTwoInt;
                    System.out.println("Result:" + " " + calculationForInteger);
                } catch (ArithmeticException error) {
                    System.out.println("Zero is not dividable\n");
                }
            }
        }
    }
}