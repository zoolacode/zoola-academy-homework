package com.zoolatech.lecture5.tasks._5;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Create a class KthLargest with a single method int add(int value)
 * that accepts a value and returns the kth largest value in a stream of numbers
 * (the amount of numbers is increasing). Number k should be passed during the object construction.
 * Return -1 if the number of values seen so far is less than k.
 *
 * a. new KthLargest(2)
 * add(1) // -1
 * add(2) // 1
 * add(5) // 2
 * add(6) // 5
 * add(4) // 5
 */
public class KthLargest {
    private int k;
    LinkedList<Integer> allNumbers = new LinkedList<>();
    public KthLargest(int k) {
        this.k = k;
    }

    public int add(int value) {
        allNumbers.add(value);
        int returnNumber;
        if (allNumbers.size() < k) {
            return -1;
        } else {
            Collections.sort(allNumbers);
            returnNumber = allNumbers.get(allNumbers.size()-k);
        }
        return returnNumber;
    }
}

class Main {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2);
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(4));
    }
}
