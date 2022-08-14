package com.zoolatech.stuff;

import java.time.LocalDate;

public class PairTest2 {
    public static void main(String[] args) {
        Integer[] birthdays = {1, 2, 3, 4, 5, 6};
        Pair<Integer> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min =" + mm.getFirst());
        System.out.println("max =" + mm.getSecond());
    }

}

class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax (T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<>(min, max);
    }
}

