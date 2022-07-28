package com.zoolatech.lecture4.tasks._5;

/*Write a program that accepts two numbers and a symbol of an operation (as a character)
and outputs the result of the selected operation.
Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
The program should work with decimal numbers of any length and precision.
 */

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Number5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first number, operation and second number");
        Calculation calculation = new Calculation(scanner.nextBigDecimal(), scanner.next().charAt(0), scanner.nextBigDecimal());
        System.out.println(calculation.calculations());
    }
}

class Calculation {
    BigDecimal numberOne;
    char operation;
    BigDecimal numberTwo;

    public Calculation(BigDecimal numberOne, char operation, BigDecimal numberTwo) {
        this.numberOne = numberOne;
        this.operation = operation;
        this.numberTwo = numberTwo;
    }

    public BigDecimal calculations() {
        BigDecimal bigDecimal = null;
        try {
            switch (operation) {
                case '+':
                    bigDecimal = numberOne.add(numberTwo);
                    return bigDecimal;
                case '-':
                    bigDecimal = numberOne.subtract(numberTwo);
                    return bigDecimal;
                case '*':
                    bigDecimal = numberOne.multiply(numberTwo);
                    return bigDecimal;
                case '/':
                    bigDecimal = numberOne.divide(numberTwo);
                    return bigDecimal;
                case '%':
                    bigDecimal = numberOne.remainder(numberTwo);
                    return bigDecimal;
                default:
                    return bigDecimal;
            }
        } catch (InputMismatchException error) {
            System.out.println("False input" + error);
        }
        return bigDecimal;
    }
}
