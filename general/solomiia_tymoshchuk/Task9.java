package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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
    public static void main (String[] args) {
        System.out.println("Enter number");
        Task9 task9 = new Task9();
        task9.reversedInput();
    }
}
