package com.zoolatech.lecture5.tasks._5;

/**
 *Create a class KthLargest with a single method int add(int value) that accepts a value and returns the kth largest
 *  value in a stream of numbers (the amount of numbers is increasing). Number k should be passed during the
 *  object construction. Return -1 if the number of values seen so far is less than k.
 */

public class Task5 {
    public static void main(String[] args) {
        KthLargest kth1 = new KthLargest(2);
        System.out.println(kth1.add(1));
        System.out.println(kth1.add(2));
        System.out.println(kth1.add(5));
        System.out.println(kth1.add(6));
        System.out.println(kth1.add(4));

        System.out.println("\n");

        KthLargest kth2 = new KthLargest(3);
        System.out.println(kth2.add(1));
        System.out.println(kth2.add(5));
        System.out.println(kth2.add(8));
        System.out.println(kth2.add(6));
        System.out.println(kth2.add(2));
        System.out.println(kth2.add(1));
        System.out.println(kth2.add(7));
    }
}
