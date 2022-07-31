package com.zoolatech.lecture5.tasks._1;

/*
Create a method that accepts an integer N and a variable amount of other integer numbers.
The method needs to return the value of the Nth (1-based) smallest element in the array.
Return -1 if the amount of passed integers is less than N.
Input: 4, 1, 5, 2, 3, 7
Output: 5 (the 4th smallest number in the array 1, 5, 2, 3, 7 is 5: 1 2 3 5 7)
Input: 3, 1, 2
Output: -1
*/

import java.util.*;

public class Number1 {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(7);

        int N = 4;

        Number1 number1 = new Number1();
        number1.task(N, arrayList);
    }

    public void task(int N, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayListOriginal = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arrayListOriginal.add(i);
        }
        Collections.copy(arrayListOriginal, arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            if (N - 1 > arrayList.size()) {
                System.out.println(error(N, arrayList));
                break;
            } else if (N - 1 < arrayList.size()) {
                ArrayListEditor.ArrayListSort arrayListSort = new ArrayListEditor.ArrayListSort();
                arrayListSort.sortArrayList(arrayList);

                if (arrayList.get(i) == arrayList.toArray()[N - 1]) {
                    System.out.print(arrayList.get(i) + " the " + N + "th smallest number in the array " + arrayListOriginal + " is ");
                    ArrayListEditor arrayListSorted = new ArrayListEditor(arrayList);
                    System.out.print(arrayList.get(i) + "" + arrayListSorted);
                }
            }
        }
    }

    public int error(int N, ArrayList<Integer> arrayList) {

        for (int ignored : arrayList) {
            if (N > arrayList.size()) {
                return -1;
            }
        }
        return 0;
    }
}

class ArrayListEditor {

    ArrayList<Integer> arrayList;

    public ArrayListEditor(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    static class ArrayListSort {
        public void sortArrayList(ArrayList<Integer> arrayList) {
            Collections.sort(arrayList);
        }
    }

    @Override
    public String toString() {
        return ": " + arrayList;
    }
}