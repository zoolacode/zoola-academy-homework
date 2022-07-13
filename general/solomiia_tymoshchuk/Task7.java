package general.com.zoolatech.lecture1.tasks._1.solomiia_tymoshchuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    List<Integer> newarr = new ArrayList<Integer>();

    void oddNumbers() {
            for(int k=getNumber();k>=0;k--){
                if (k % 2 != 0) {
                newarr.add(k);}
            }
        newarr.forEach(System.out::println);
    }

    void oddNumbersWhile() {
        int i = getNumber();
        while (i>=0){
            if (i % 2 != 0) {
               newarr.add(i);}
            i--;
        }
        newarr.forEach(System.out::println);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public List<Integer> getNewarr() {
        return newarr;
    }

    public void setNewarr(List<Integer> newarr) {
        this.newarr = newarr;
    }

    public static void main (String[] args) {
        System.out.println("Enter number");
        Task7 task7 = new Task7();
        task7.oddNumbersWhile();
    }
}
