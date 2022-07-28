package com.zoolatech.lecture1.tasks._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10);
        System.out.println("Initial value: " + calculator.getInitialValue());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your operand");
        double inputValue = scanner.nextDouble();
        System.out.println("Enter your operator('+', '-', '*', '/'");
        char operatorSymbol = scanner.next().charAt(0);
        scanner.close();
        switch (operatorSymbol){
            case '+' -> calculator.addValues(inputValue);
            case '-' -> calculator.subtractValues(inputValue);
            case '*' -> calculator.multiplyValues(inputValue);
            case '/' -> calculator.divideValues(inputValue);
            default -> throw new IllegalStateException("Invalid symbol: " + operatorSymbol);
        };
        System.out.println("Current value: " + calculator.getInitialValue());
    }
}
