package com.zoolatech.lecture1.tasks._1;

import java.util.*;

public class SmallestElement {

    void smallestElement(int N, List<Integer> originalList) {
        System.out.println("Original array: " + originalList);
        List<Integer> newList = originalList.stream().sorted().toList();
        if (newList.size() < N) {
            System.out.println(-1);
        } else {
            System.out.println("N smallest element: " + newList.get(N + 1));
        }
    }

    public static void main(String[] args) {
        // input format should be 2,3,4,5
        Scanner sc = new Scanner(System.in);
        int N = 4;
        List<Integer> values = Arrays.stream(sc.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed().toList();

        SmallestElement smallestElement = new SmallestElement();
        smallestElement.smallestElement(N, values);
    }
}
