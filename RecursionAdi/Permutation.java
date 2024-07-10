package RecursionAdi;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] arr = {1,2,3};
//        boolean[] map = new boolean[arr.length];
//        solve(arr, map, new ArrayList<>(), result);
        solve(arr, 0, result);
        System.out.println(result);
    }

//     Optimised space : O(1);
    static void solve(int[] arr, int idx, List<List<Integer>> result) {
        if(idx == arr.length) {
            List<Integer> list = new ArrayList<>();
            for(int n : arr) list.add(n);
            result.add(list);
            return;
        }

        for(int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            solve(arr, idx + 1, result);
            swap(arr, i, idx);
        }
    }

    private static void swap(int[] arr, int i, int idx) {
        int t = arr[i];
        arr[i] = arr[idx];
        arr[idx] = t;
    }


//    Taking extra space
//    static void solve(int[] arr, boolean[] map, List<Integer> list, List<List<Integer>> result) {
//        if(list.size() == arr.length ) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//
//        for(int i = 0; i < arr.length; i++) {
//            if(!map[i]) {
//                map[i] = true;
//                list.add(arr[i]);
//                solve(arr, map, list, result);
//                map[i] = false; // Backtrack
//                list.remove(list.size() - 1);
//            }
//        }
//    }
}
