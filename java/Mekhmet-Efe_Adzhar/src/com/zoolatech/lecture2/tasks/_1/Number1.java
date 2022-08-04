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

        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first number:");

        //MARK: IF INTEGER
        if (scanner.hasNextInt()) {
            calculator.setInteger(true);
            int numberOne = scanner.nextInt();

            System.out.println("Choose operation:");
            char operation = scanner.next().charAt(0);
            System.out.println("1. Input second integer:\n2. Get current value");

            if (scanner.nextInt() == 2) {
                System.out.println(numberOne);
            }
            System.out.println("Input second integer");
            int numberTwo = scanner.nextInt();

            switch (operation) {
                case '+' -> calculator.addition(numberOne, numberTwo);
                case '-' -> calculator.subtraction(numberOne, numberTwo);
                case '*' -> calculator.multiplication(numberOne, numberTwo);
                case '/' -> calculator.division(numberOne, numberTwo);
                default -> System.out.println("Error");
            }
        }

        //MARK: IF DOUBLE
        else if (scanner.hasNextDouble()) {
            calculator.setInteger(false);
           double numberOneDouble = scanner.nextDouble();

            System.out.println("Choose operation:");
            char operation = scanner.next().charAt(0);
            System.out.println("1. Input second double:\n2. Get current value");

            if (scanner.nextInt() == 2) {
                System.out.println(numberOneDouble);
            }
            System.out.println("Input second double");

           double numberTwoDouble = scanner.nextDouble();

                switch (operation) {
                    case '+' -> calculator.addition(numberOneDouble, numberTwoDouble);
                    case '-' -> calculator.subtraction(numberOneDouble, numberTwoDouble);
                    case '*' -> calculator.multiplication(numberOneDouble, numberTwoDouble);
                    case '/' -> calculator.division(numberOneDouble, numberTwoDouble);
                    default -> System.out.println("ERROR");
                }
            }
        }
    }


class Calculator {

    private boolean isInteger;

    public void setInteger(boolean integer) {
        isInteger = integer;
    }

    public void addition(double numberOneDouble, double numberTwoDouble) {
        if (isInteger) {

            int numberOneInt = (int) numberOneDouble;
            int numberTwoInt = (int) numberTwoDouble;

            int calculationForInteger = numberOneInt + numberTwoInt;
            System.out.println("Result:" + " " + calculationForInteger);
        }
        else {
            double calculationForDouble = numberOneDouble + numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
    }

    public void subtraction(double numberOneDouble, double numberTwoDouble) {
        if (isInteger) {
            int numberOneInt = (int) numberOneDouble;
            int numberTwoInt = (int) numberTwoDouble;

           int calculationForInteger = numberOneInt - numberTwoInt;
            System.out.println("Result:" + " " + calculationForInteger);
        }
        else {
           double calculationForDouble = numberOneDouble - numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
    }

    public void multiplication(double numberOneDouble, double numberTwoDouble) {
        if (isInteger) {
            int numberOneInt = (int) numberOneDouble;
            int numberTwoInt = (int) numberTwoDouble;

            int calculationForInteger = numberOneInt * numberTwoInt;
            System.out.println("Result:" + " " + calculationForInteger);
        }
        else {
            double calculationForDouble = numberOneDouble * numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
    }

    public void division(double numberOneDouble, double numberTwoDouble) {
        int numberOneInt = (int) numberOneDouble;
        int numberTwoInt = (int) numberTwoDouble;

        if (!isInteger) {
            if (numberOneDouble == 0.0 && numberTwoDouble == 0.0) {
                System.out.println("Zero is not dividable\n");
            } else {
                try {
                    double calculationForDouble = numberOneDouble / numberTwoDouble;
                    System.out.println("Result:" + " " + calculationForDouble);
                } catch (ArithmeticException error) {
                    System.out.println("Zero is not dividable\n");
                }
            }
        } else {
            if (numberOneInt == 0 && numberTwoInt == 0) {
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