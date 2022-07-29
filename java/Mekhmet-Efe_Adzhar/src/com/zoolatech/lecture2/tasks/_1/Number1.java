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
        Scanner scanner = new Scanner(System.in);
        Number1 number1 = new Number1();
        Calculator calculator = new Calculator();
        calculator.setCurrentValueInt(0);
        calculator.setCurrentValueDouble(0.0);
        System.out.println("1. Start\n2. Get current value");

        switch (scanner.nextInt()) {
            case 1 -> number1.calculations();
            case 2 -> {
                calculator.getCurrentValue();
                number1.calculations();
            }
            default -> throw new IllegalArgumentException("Unknown" + scanner.nextInt());
        }
    }

    void calculations() {

        Calculator calculator = new Calculator();

        RangeOfNumber rangeOfNumber = new RangeOfNumber();

        int numberOne = 0, numberTwo;
        double numberOneDouble, numberTwoDouble;
        char operation;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input first number:");

        //MARK: IF INTEGER
        if (scanner.hasNextInt()) {
            calculator.isInteger = true;
            numberOne = scanner.nextInt();
            calculator.setCurrentValueInt(numberOne);

            System.out.println("Choose operation:");
            operation = scanner.next().charAt(0);
            System.out.println("1. Input second integer:\n2. Get current value");

            if (scanner.nextInt() == 2) {
                calculator.getCurrentValue();
            }
            System.out.println("Input second integer");
            numberTwo = scanner.nextInt();
            calculator.setNumberOne(numberOne);
            calculator.setNumberTwo(numberTwo);

            rangeOfNumber.rangeOfNumberInt(numberOne, numberTwo);

            if (!rangeOfNumber.outOfRange) {
                switch (operation) {
                    case '+' -> calculator.addition();
                    case '-' -> calculator.subtraction();
                    case '*' -> calculator.multiplication();
                    case '/' -> calculator.division();
                    default -> System.out.println("Error");
                }
            }
        }

        //MARK: IF DOUBLE
        else if (scanner.hasNextDouble()) {
            calculator.isInteger = false;
            numberOneDouble = scanner.nextDouble();
            calculator.setCurrentValueDouble(numberOneDouble);

            System.out.println("Choose operation:");
            operation = scanner.next().charAt(0);
            System.out.println("1. Input second double:\n2. Get current value");

            if (scanner.nextInt() == 2) {
                calculator.getCurrentValue();
            }
            System.out.println("Input second double");

            numberTwoDouble = scanner.nextDouble();

            calculator.setNumberOneDouble(numberOneDouble);
            calculator.setNumberTwoDouble(numberTwoDouble);
            rangeOfNumber.rangeOfNumberDouble(numberOneDouble, numberTwoDouble);

            if (!rangeOfNumber.outOfRange) {
                switch (operation) {
                    case '+' -> calculator.addition();
                    case '-' -> calculator.subtraction();
                    case '*' -> calculator.multiplication();
                    case '/' -> calculator.division();
                    default -> System.out.println("ERROR");
                }
            }
        }
    }
}

class Calculator {

    Number1 number1 = new Number1();

    boolean isInteger;
    private double calculationForDouble;
    private int calculationForInteger;
    private int currentValueInt;
    private double currentValueDouble;

    private int numberOne;
    private int numberTwo;
    private double numberOneDouble;
    private double numberTwoDouble;

    public void setCurrentValueInt(int currentValueInt) {
        this.currentValueInt = currentValueInt;
    }

    public void setCurrentValueDouble(double currentValueDouble) {
        this.currentValueDouble = currentValueDouble;
    }

    public void getCurrentValue() {
        if (isInteger) {
            System.out.println("Current value is " + currentValueInt);
        } else {
            System.out.println("Current value is " + currentValueDouble );

        }
    }

    public void setNumberOne(int numberOne) {
        this.numberOne = numberOne;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }

    public void setNumberOneDouble(double numberOneDouble) {
        this.numberOneDouble = numberOneDouble;
    }

    public void setNumberTwoDouble(double numberTwoDouble) {
        this.numberTwoDouble = numberTwoDouble;
    }

    public void addition() {
        if (!isInteger) {
            calculationForDouble = numberOneDouble + numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
        else {
            calculationForInteger = numberOne + numberTwo;
            System.out.println("Result:" + " " + calculationForInteger);
        }
    }

    public void subtraction() {
        if (!isInteger) {
            calculationForDouble = numberOneDouble - numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
        else {
            calculationForInteger = numberOne - numberTwo;
            System.out.println("Result:" + " " + calculationForInteger);
        }
    }

    public void multiplication() {
        if (!isInteger) {
            calculationForDouble = numberOneDouble * numberTwoDouble;
            System.out.println("Result:" + " " + calculationForDouble);
        }
        else {
            calculationForInteger = numberOne * numberTwo;
            System.out.println("Result:" + " " + calculationForInteger);
        }
    }

    public void division() {
        if (!isInteger) {
            if (numberOneDouble == 0.0) {
                System.out.println("Zero is not dividable\n");
                number1.calculations();
            } else {
                try {
                    calculationForDouble = numberOneDouble / numberTwoDouble;
                    System.out.println("Result:" + " " + calculationForDouble);
                } catch (ArithmeticException error) {
                    System.out.println("Zero is not dividable\n");
                    number1.calculations();
                }
            }
        } else {
            if (numberOne == 0) {
                System.out.println("Zero is not dividable\n");
                number1.calculations();
            } else {
                try {
                    calculationForInteger = numberOne / numberTwo;
                    System.out.println("Result:" + " " + calculationForInteger);
                } catch (ArithmeticException error) {
                    System.out.println("Zero is not dividable\n");
                    number1.calculations();
                }
            }
        }
    }
}

class RangeOfNumber {

    Calculator calculator = new Calculator();

    boolean outOfRange;

    public void rangeOfNumberInt(int number1, int number2) {
        int resultOfAddition = number1 + number2;
        int resultOfMultiplication = number1 * number2;

        if (resultOfAddition == Integer.MAX_VALUE || resultOfMultiplication == Integer.MAX_VALUE) {
            for (int i = 0; i < 2; i++) {
                resultOfAddition = Math.addExact(resultOfAddition, 1);
                resultOfMultiplication = Math.addExact(resultOfMultiplication, 1);
            }
        }
        else if (calculator.isInteger) {
            try {
                outOfRange = false;
            } catch (IllegalArgumentException error) {
                System.out.println("Out of Range" + error);
            }
        }
    }

    public void rangeOfNumberDouble(double number1, double number2) {
        double resultOfAddition = number1 + number2;
        double resultOfMultiplication = number1 * number2;

        if (resultOfAddition == Double.MAX_VALUE || resultOfMultiplication == Double.MAX_VALUE) {
            throw new ArithmeticException("Out of range");
        }
        else if (!calculator.isInteger) {
            try {
                outOfRange = false;
            } catch (IllegalArgumentException error) {
                System.out.println("Out of Range" + error);
            }
        }
    }
}