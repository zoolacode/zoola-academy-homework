package com.zoolatech.lecture5.tasks._5;

/*Create a class KthLargest with a single method int add(int value) that accepts a value and returns the kth largest value
in a stream of numbers (the amount of numbers is increasing). Number k should be passed during the object construction.
Return -1 if the number of values seen so far is less than k.
new KthLargest(2)
add(1) // -1
add(2) // 1
add(5) // 2
add(6) // 5
add(4) // 5
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Number5 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(2);
        System.out.println(kthLargest.add(1));
        System.out.println(kthLargest.add(2));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(6));
        System.out.println(kthLargest.add(4));

    }
}

class KthLargest {

    private final int value;
    List<Integer> integerList = new ArrayList<>();
    Iterator<Integer> iterator = integerList.iterator();

    public KthLargest(int value) {
        this.value = value;
    }

    public int add(int value) {
        integerList.add(value);
        if (iterator.hasNext()) {
            if (integerList.get(integerList.size() - 1).compareTo(this.value) < 0) {
                return -1;
            }
        }
        Collections.sort(integerList);
        return integerList.get(integerList.size() - this.value);
    }
}