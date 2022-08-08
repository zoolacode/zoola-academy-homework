package com.zoolatech.lecture5.tasks._5;

import java.util.Collections;
import java.util.LinkedList;

public class KthLargest {
    private final int k;
    private final LinkedList<Integer> numbers = new LinkedList();

    public KthLargest(int k) {
        this.k = k;
    }

    public int add(int value) {
        numbers.add(value);
        if (k > numbers.size()) {
            return -1;
        } else {
            Collections.sort(numbers);
            return numbers.get(numbers.size() - k);
        }
    }
}
