package com.zoolatech.lecture2.tasks._1;

import java.util.Scanner;

/**
 * Define a class that represents a calculator. The class should provide methods that accept
 * another value and perform addition, subtraction, multiplication and division operations
 * on a value stored in a calculator instance. Divides by a zero should be forbidden and ignored.
 * The class should also provide a method to get a current value. The class should work with both
 * integer and double numbers (ignore roundoff errors). Assume all operation results fit into the
 * range of values for a current value type.
 */
public class TaskOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number to calculate:");
        Calculator calculator = new Calculator(scanner.nextDouble());
        boolean flag = true;
        while (flag) {
            System.out.println("Input operation ('+','-','*','/'):");
            String c = scanner.next();
            System.out.println("Input a number for operation:");
            double value = scanner.nextDouble();
            calculateDouble(value, c, calculator);
            System.out.println("Do you want to continue operation?(Y/N)");
            flag = scanner.hasNext("Y");
            scanner.next();
        }
    }

    public static void calculateDouble(double value, String c, Calculator calculator) {
        double oldValue = calculator.getNumber();
        switch (c) {
            case "+" -> calculator.add(value);
            case "-" -> calculator.subtract(value);
            case "*" -> calculator.multiply(value);
            case "/" -> calculator.divide(value);
            default -> System.out.println("operator: '" + c + "' does not exist");
        }
        if (Double.compare(oldValue, calculator.getNumber()) != 0) {
            System.out.println(oldValue + c + value + "=" + calculator.getNumber());
        }
    }
}
