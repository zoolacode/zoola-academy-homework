package com.zoolatech.lecture2.tasks._1;

public class Calculator {
    private double currentValue;
    public double getCurrentValue() {
        return currentValue;
    }
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public void addition(double nextNumber) {
        this.currentValue = getCurrentValue() + nextNumber;
        System.out.println(" = " + getCurrentValue());
    }

    public void subtraction(double nextNumber) {
        this.currentValue = getCurrentValue() - nextNumber;
        System.out.println(" = " + getCurrentValue());
    }

    public void multiplication(double nextNumber) {
        this.currentValue = getCurrentValue() * nextNumber;
        System.out.println(" = " + getCurrentValue());
    }

    public void division(double nextNumber) {
        if (nextNumber == 0) {
            System.out.println("Are you mad? Cannot divide by 0");
        } else {
            this.currentValue = getCurrentValue() / nextNumber;
            System.out.println(" = " + getCurrentValue());
        }
    }
}

