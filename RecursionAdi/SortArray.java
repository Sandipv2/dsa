package RecursionAdi;

import java.util.*;

public class SortArray {
    static void sort(List<Integer> arr) {
        if(arr.size() == 1) {
            return;
        }

        int temp = arr.remove(arr.size() - 1);
        sort(arr);
        insert(arr, temp);

//        This can be done too.
//        for(int i = 0; i < arr.size(); i++) {
//            if(temp < arr.get(i)) {
//                arr.add(i, temp);
//                return;
//            }
//        }
    }

    static void insert(List<Integer> arr, int elem) {
        if(arr.size() == 0 || elem >= arr.get(arr.size() - 1)) {
            arr.add(elem);
            return;
        }

        int val = arr.remove(arr.size() - 1);
        insert(arr, elem);
        arr.add(val);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.add(4);

        System.out.println(arr);
        sort(arr);
        System.out.println(arr);
    }
}
