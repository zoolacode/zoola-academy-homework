package com.zoolatech.lecture2.tasks._1;

/**
 * Define a class that represents a calculator. The
 * class should provide methods that accept another
 * value and perform addition, subtraction,
 * multiplication and division operations on a value
 * stored in a calculator instance. Divides by a
 * zero should be forbidden and ignored. The class
 * should also provide a method to get a current
 * value. The class should work with both integer
 * and double numbers (ignore roundoff errors).
 * Assume all operation results fit into the range
 * of values for a current value type.
 */
public class Calculator {
    private double storedValue;

    public Calculator(double value) {
        storedValue = value;
    }

    public double getStoredValue() {
        return storedValue;
    }

    public void addition(double operand) {
        storedValue += operand;
    }

    public void subtract(double operand) {
        storedValue -= operand;
    }

    public void multiplic(double operand) {
        storedValue *= operand;
    }

    public void divide(double operand) {
        if (operand == 0) {
            System.out.println("Keep in mind that division by 0 is ignored!");
        } else {
            storedValue /= operand;
        }
    }
}
