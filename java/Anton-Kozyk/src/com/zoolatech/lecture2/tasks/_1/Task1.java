package com.zoolatech.lecture2.tasks._1;

/**
 * Define a class that represents a calculator. The class should provide methods that
 * accept another value and perform addition, subtraction, multiplication and division
 * operations on a value stored in a calculator instance. Divides by a zero should be
 * forbidden and ignored. The class should also provide a method to get a current value.
 * The class should work with both integer and double numbers (ignore roundoff errors).
 * Assume all operation results fit into the range of values for a current value type.
 */

public class Task1 {
    public static void main(String[] args) {
        Calculator calc = new Calculator(10);

        //Test block
        calc.getValue();
        calc.addition(5);
        calc.division(0);
        calc.multiplication(4);
        calc.subtraction(7);
        System.out.println("--------------");
        calc.setValue(19.123);
        calc.addition(1.3);
        calc.division(2.5);
    }
}

class Calculator {
    double value;

    Calculator(double value) {
        this.value = value;
    }

    public double addition(double another_value) {
        double result;
        result = value + another_value;
        System.out.println(value + " + " + another_value + " = " + result);
        return result;
    }

    public double subtraction(double another_value) {
        double result;
        result = value - another_value;
        System.out.println(value + " - " + another_value + " = " + result);
        return result;
    }

    public double multiplication(double another_value) {
        double result;
        result = value * another_value;
        System.out.println(value + " * " + another_value + " = " + result);
        return result;
    }

    public double division(double another_value) {
        double result = 0;
        if (another_value == 0) {
            System.out.println("Zero division!");
        } else {
            result = value / another_value;
            System.out.println(value + " / " + another_value + " = " + result);
        }
        return result;
    }

    public void getValue() {
        System.out.println("Current value is: " + value);
    }

    public void setValue(double value) {
        this.value = value;
        System.out.println("New value is: " + this.value);
    }
}
