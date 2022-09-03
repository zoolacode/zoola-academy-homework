package com.zoolatech.lecture5.tasks._5;

/**
 * Create a class KthLargest with a single method int add(int value) that accepts a value and returns the kth
 * largest value in a stream of numbers (the amount of numbers is increasing). Number k should be passed during the
 * object construction. Return -1 if the number of values seen so far is less than k.
 * new KthLargest(2)
 * add(1) // -1
 * add(2) // 1
 * add(5) // 2
 * add(6) // 5
 * add(4) // 5
 */

public class Task5 {
    public static void main(String[] args) {
        KthLargest k = new KthLargest(2);
        System.out.println(k.add(1));
        System.out.println(k.add(2));
        System.out.println(k.add(5));
        System.out.println(k.add(6));
        System.out.println(k.add(4));
    }
}
