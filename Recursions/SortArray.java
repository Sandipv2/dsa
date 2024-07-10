package Recursions;

import java.util.*;

public class SortArray {
    static void sort(List<Integer> arr) {
        if(arr.size() == 1) {
            return;
        }

        int temp = arr.remove(arr.size() - 1);
        sort(arr);

        insert(arr, temp);
    }

    static void insert(List<Integer> arr, int temp) {
        if(arr.size() == 0 || temp > arr.get(arr.size() - 1)) {
            arr.add(temp);
            return;
        }

        int val = arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(val);
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(5);
        arr.add(1);
        arr.add(4);
        arr.add(2);

        System.out.println(arr);
        sort(arr);
        System.out.println(arr);
    }
}
