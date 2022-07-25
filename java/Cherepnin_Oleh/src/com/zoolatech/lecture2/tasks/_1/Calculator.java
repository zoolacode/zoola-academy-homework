package com.zoolatech.lecture2.tasks._1;

public class Calculator {

    private double number;

    public Calculator() {
    }

    public Calculator(double number) {
        this.number = number;
    }

    public double add(double value) {
        number += value;
        return number;
    }

    public double multiply(double value) {
        number *= value;
        return number;
    }

    public double divide(double value) {
        try {
            if (value != 0) {
                number /= value;
                return number;
            } else throw new ArithmeticException("division by zero is not available");
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double subtract(double value) {
        number -= value;
        return number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
