package com.zoolatech.lecture5.tasks._5;

/**
 * Create a class KthLargest with a single method int add(int value) that accepts a value and returns the kth largest
 * value in a stream of numbers (the amount of numbers is increasing). Number k should be passed during the object
 * construction. Return -1 if the number of values seen so far is less than k.
 * new KthLargest(2)
 * add(1) // -1
 * add(2) // 1
 * add(5) // 2
 * add(6) // 5
 * add(4) // 5
 */
public class TaskFive {
    public static void main(String[] args) {
        KthLargest largest = new KthLargest(3);
        System.out.println(largest.add(2));
        System.out.println(largest.add(1));
        System.out.println(largest.add(4));
        System.out.println(largest.add(3));
        System.out.println(largest.add(5));
        System.out.println(largest.add(6));
        System.out.println(largest.add(7));
        System.out.println(largest.add(8));
        System.out.println(largest.add(9));
    }
}

