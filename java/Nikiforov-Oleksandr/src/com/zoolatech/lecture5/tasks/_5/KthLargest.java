package com.zoolatech.lecture5.tasks._5;

import java.util.ArrayList;
import java.util.Collections;

public class KthLargest {
    private ArrayList<Integer> arrayList;
    private final int k;
    private int arrSize = 0;

    public KthLargest(int k) {
        this.arrayList = new ArrayList<>();
        this.k = k;
    }

    public int add(int value) {
        arrayList.add(value);
        arrSize++;
        if (arrSize < k) {
            return -1;
        }
        Collections.sort(arrayList);
        return arrayList.get(arrSize - k);
    }
}
