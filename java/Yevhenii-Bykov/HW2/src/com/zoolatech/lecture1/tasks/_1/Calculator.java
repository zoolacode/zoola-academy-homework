package com.zoolatech.lecture1.tasks._1;

/**
 * Define a class that represents a calculator.
 * The class should provide methods that accept another value
 * and perform addition, subtraction, multiplication and division operations
 * on a value stored in a calculator instance.
 * Divides by a zero should be forbidden and ignored.
 * The class should also provide a method to get a current value.
 * The class should work with both integer and double numbers (ignore roundoff errors).
 * Assume all operation results fit into the range of values for a current value type.
 */

public class Calculator {
    private double initialValue;

    Calculator(double initialValue){
        this.initialValue = initialValue;
    }

    public void addValues(double x) {
        initialValue += x;
    }

    public void subtractValues(double x) {
        initialValue -= x;
    }

    public void multiplyValues(double x) {
        initialValue *= x;
    }

    public void divideValues(double x) {
        if (x == 0) {
            System.out.println("Zero division error");
        } else {
            initialValue /= x;
        }
    }

    public double getInitialValue() {
        return initialValue;
    }
}
