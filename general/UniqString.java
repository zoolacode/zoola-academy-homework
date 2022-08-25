package general;

import java.util.*;
import java.util.stream.Collectors;

public class UniqString {
    static void uniqElements(List<String> listAll) {
        List<String> listDistinct = listAll.stream().distinct().collect(Collectors.toList());
        String collectDistinct = listDistinct.stream().collect(Collectors.joining(", "));
        System.out.println(collectDistinct);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String element = sc.next();
        ArrayList<String> list = new ArrayList<String>(Collections.singleton(element));
        list.add(sc.next());
        uniqElements(list);
    }
}
