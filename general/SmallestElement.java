package general;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestElement {

//    int [] newStr;

    void smallestElement(int N, List<Integer> originalList, int...newStr) {
//        List<Integer> originalList = Arrays.asList(10, 5, 6, 7, 8, 3, 2);
        Arrays.asList(newStr);
        System.out.println("Original array: "+ originalList);
        List<Integer> newList = originalList.stream().sorted().collect(Collectors.toList());
        if (newList.size() < N) {
            System.out.println(-1);
        } else {
            System.out.println("N smallest element: "+newList.get(N + 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine().split(",");
        SmallestElement smallestElement = new SmallestElement();
        smallestElement.smallestElement(N,new ArrayList<>(),1,2,3,4,5);
    }
}
