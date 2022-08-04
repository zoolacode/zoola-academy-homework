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
        Calculator calc = new Calculator(0);

        //Test block
        System.out.println(calc.getValue());
        calc.addition(10);
        calc.division(2);
        System.out.println(calc.getValue());
        calc.division(0);
        calc.multiplication(100);
        calc.subtraction(150);
        System.out.println(calc.getValue());
    }
}

class Calculator {
    private double value;

    Calculator(double value) {
        this.value = value;
    }

    public double addition(double anotherValue) {
        value += anotherValue;
        return value;
    }

    public double subtraction(double anotherValue) {
        value -= anotherValue;
        return value;
    }

    public double multiplication(double anotherValue) {
        value *= anotherValue;
        return value;
    }

    public double division(double anotherValue) {
        if (anotherValue == 0) {
            System.out.println("Zero division!");
        } else {
            value /= anotherValue;
        }
        return value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
