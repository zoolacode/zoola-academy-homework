package com.zoolatech.lecture5.tasks._5;

import java.util.*;

public class KthLargest {
    private final Queue<Integer> values = new PriorityQueue<>();
    private final int kLargest;

    public KthLargest(int kLargest) {
        this.kLargest = kLargest;
    }

    public int add(int value) {
        if (values.size() < kLargest) {
            values.offer(value);
            if (values.size() < kLargest) {
                return -1;
            }
            return values.peek();
        }

        if (values.peek() <= value) {
            values.poll();
            values.offer(value);
        }
        return values.peek();
    }
}
