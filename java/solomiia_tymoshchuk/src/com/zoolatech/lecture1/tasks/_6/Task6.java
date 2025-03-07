package com.zoolatech.lecture1.tasks._6;

import java.util.Objects;
import java.util.Scanner;

/**
 * Write a program that accepts two numbers and a symbol of an operation
 * (as a character) and outputs the result of the selected operation.
 * Possible characters for the operation: ‘+’, ‘-’, ‘*’, ‘/’, ‘%’.
 * The program should work only with integer values.
 * Create two versions of the program: one should use the if-else statement, second - the switch statement.
 **/
public class Task6 {
    private final int number;
    private final int number1 ;
    private final char operator;

    public Task6(int number, int number1, char operator){
        this.number = number;
        this.number1 = number1;
        this.operator = operator;
    }

    void calculateNumbersSwitchCase() {
        switch (operator) {
            case '+' -> System.out.println(number + number1);
            case '-' -> System.out.println(number - number1);
            case '*' -> System.out.println(number * number1);
            case '/' -> System.out.println(number / number1);
            case '%' -> System.out.println(number % number1);
        }
    }

    void calculateNumbersIfWay() {
        if (operator == '+') {
            System.out.println(number + number1);
        } else if (Objects.equals(operator, '-')) {
            System.out.println(number - number1);
        } else if (Objects.equals(operator, '*')) {
            System.out.println(number * number1);
        } else if (Objects.equals(operator, '/')) {
            System.out.println(number / number1);
        } else if (Objects.equals(operator, '%')) {
            System.out.println(number % number1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int number1 = sc.nextInt();
        char operator = sc.next().charAt(0);
        Task6 task6 = new Task6(number, number1, operator);
        task6.calculateNumbersIfWay();
    }
}
