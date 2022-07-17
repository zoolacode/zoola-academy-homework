package com.zoolatech.lecture2.tasks._1;


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
            System.out.println("Division by 0 is forbidden");
            storedValue = 0;
        } else {
            storedValue /= operand;
        }
    }
}
