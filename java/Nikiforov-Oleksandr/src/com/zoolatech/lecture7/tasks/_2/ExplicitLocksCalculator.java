package com.zoolatech.lecture7.tasks._2;

import java.util.concurrent.locks.ReentrantLock;

public class ExplicitLocksCalculator extends Calculator{
    private final ReentrantLock lock = new ReentrantLock();
    public ExplicitLocksCalculator(int value) {
        super(value);
    }

    @Override
    public void add(int valueToAdd){
        lock.lock();
        try{
            super.add(valueToAdd);
            System.out.println("Add - "+valueToAdd);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void subtract(int valueToSubtract){
        lock.lock();
        try{
            super.subtract(valueToSubtract);
            System.out.println("Subtract - "+valueToSubtract);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public Object getValue() {
        return value;
    }
}
