package com.zoolatech.lecture2.tasks._1;

public class Calculator {

    private double number;

    public Calculator() {
        this(0);
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
        if (value != 0) {
            number /= value;
            return number;
        }else System.out.println("division by zero is not available");
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
