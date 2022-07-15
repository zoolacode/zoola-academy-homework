package general.solomiia_tymoshchuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that accepts an integer value and
 * outputs all its digits in the reverse order on a new line.
 **/
public class Task9 {
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    List<Character> newarr = new ArrayList<Character>();

    void reversedInput() {
        String string = Integer.toString(number);
        char newChar;
        char[] ch = string.toCharArray();

        for (int i = ch.length - 1; i >= 0; i--) {
            newChar = ch[i];
            newarr.add(newChar);
        }
        newarr.forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Enter number");
        Task9 task9 = new Task9();
        task9.reversedInput();
    }
}
