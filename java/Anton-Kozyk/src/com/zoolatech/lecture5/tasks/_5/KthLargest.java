package com.zoolatech.lecture5.tasks._5;

import java.util.ArrayList;
import java.util.Collections;

public class KthLargest {
    ArrayList<Integer> numbers = new ArrayList<>();
    private final int k;

    public KthLargest(int k) {
        this.k = k;
    }

    public int add(int value) {
        numbers.add(value);
        Collections.sort(numbers);
        return numbers.size() >= k ? numbers.get(numbers.size() - k) : -1;
    }
}
