package com.zoolatech.lecture5.tasks._1;

import java.util.Arrays;

public class ArrayTest {
    private  static class MyClass {
        public String aField;
        public MyClass(String f) {
            aField = f;
        }
    }

    public static void main(String[] args) {
        String[] words = {"hello", "we", "are", "from", "Ukraine"};
        deleteElement(words, 2);
        System.out.println(Arrays.toString(words));

        deleteElement(new Integer[] {1, 2 ,3}, 1);

        MyClass[] myClasses = new MyClass[4];
        deleteElement(myClasses, 1);
    }

    private static <T> void deleteElement(T[] array, int indexToDelete) {
        int length = array.length;
        for (int i = indexToDelete; i < length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[length-1] = null;
    }

//    private static void deleteElement(Integer[] array, int indexToDelete) {
//        int length = array.length;
//        for (int i = indexToDelete; i < length - 1; i++) {
//            array[i] = array[i + 1];
//        }
//        array[length-1] = null;
//    }


}
