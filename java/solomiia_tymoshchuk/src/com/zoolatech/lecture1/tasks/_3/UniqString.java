package com.zoolatech.lecture1.tasks._3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UniqString {
    static void uniqElements(List<String> listAll) {
        List<String> listDistinct = listAll.stream().distinct().toList();
        String collectDistinct = String.join(", ", listDistinct);
        System.out.println(collectDistinct);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String element = sc.next();
        ArrayList<String> list = new ArrayList<>(Collections.singleton(element));
        list.add(sc.next());
        uniqElements(list);
    }
}
