package general;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.*;

public class MaxValue {

    public static <T extends Comparable<T>> Optional<T> max(List<T> list) {
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(Collections.max(list, Comparator.naturalOrder()));
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>(num);
        list.add(sc.nextInt());
        System.out.println(max(list));
    }
}
