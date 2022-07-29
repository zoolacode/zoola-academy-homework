package com.zoolatech.lecture5.tasks._5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest {
    private List<Integer> values = new ArrayList<>();
    private final int kLargest;

    public KthLargest(int kLargest) {
        this.kLargest = kLargest;
    }

    public int add(int value) {
        values.add(value);
        if (values.size() < kLargest) {
            return -1;
        }
        Collections.sort(values);
        return values.get(values.size() - kLargest);
    }
}
