package com.zoolatech.lecture5.tasks._5;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private int k;

    public KthLargest(int k) {
        this.k = k;
    }

    public int add(int value) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(value);
            if (priorityQueue.size() < k) {
                return -1;
            }
            return priorityQueue.peek();
        }

        if (priorityQueue.peek() <= value) {
            priorityQueue.poll();
            priorityQueue.add(value);
        }
        return priorityQueue.peek();
    }
}
