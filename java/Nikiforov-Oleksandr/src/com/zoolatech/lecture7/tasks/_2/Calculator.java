package com.zoolatech.lecture7.tasks._2;


public abstract class Calculator {
    protected int value;

    public Calculator(int value) {
        this.value = value;
    }

    public void add(int valueToAdd) {
        value += valueToAdd;
        System.out.println("Add - " + valueToAdd);
    }

    public void subtract(int valueToSubtract) {
        value -= valueToSubtract;
        System.out.println("Subtract - " + valueToSubtract);
    }

    public int getValue(){
        return value;
    }
}
