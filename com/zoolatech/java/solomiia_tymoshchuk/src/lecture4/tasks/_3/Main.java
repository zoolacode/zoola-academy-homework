package com.zoolatech.java.solomiia_tymoshchuk.src.lecture4.tasks._3;

public class Main {
    public static void main(String[] args) {
        test("String");
    }
        private static void test(String test){
            StringModifier stringModifier = initialString -> initialString.toUpperCase();
            StringModifier stringModifier1 = initialString -> initialString.toLowerCase();
            System.out.printf("Modiifed: %s", stringModifier.modify(test)+"\n");
            System.out.printf("Modiifed: %s",stringModifier1.modify(test)+"\n");
        }

}
