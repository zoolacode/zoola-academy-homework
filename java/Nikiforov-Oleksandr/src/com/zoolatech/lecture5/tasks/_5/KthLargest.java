package com.zoolatech.lecture5.tasks._5;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq;

    private final int k;

    public KthLargest(int k) {
        this.pq = new PriorityQueue<>(k);
        this.k = k;
    }

    public int add(int value) {
        if (pq.size() < k - 1) {
            pq.offer(value);
            return -1;
        }
        if (value > pq.peek()) {
            pq.offer(value);
        }
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

