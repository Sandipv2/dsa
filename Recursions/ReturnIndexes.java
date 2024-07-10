package Recursions;

import java.util.ArrayList;

public class ReturnIndexes {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,6};
        System.out.println(find(arr, 4, 0));
    }

    static ArrayList find(int[] arr, int target, int index) {
        ArrayList<Integer> list = new ArrayList<>();

        if(index == arr.length)
            return list;

        if(arr[index] == target)
            list.add(index);

        ArrayList<Integer> values = find(arr, target, index+1);

        list.addAll(values);

        return list;

    }
}
