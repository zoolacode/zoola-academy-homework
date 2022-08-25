package com.zoolatech.lecture7.tasks._1;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Stream.generate(Math::random).limit(10).toList());
        };
        var t = new Thread(r);
        t.start();
    }
}
