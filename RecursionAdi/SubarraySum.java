package RecursionAdi;

import java.util.ArrayList;
import java.util.List;

public class SubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        int k = 5;
        solve(0, arr, new ArrayList<>(), 0, k);
    }

    static void solve(int idx, int[] arr, List<Integer> list, int sum, int k) {
        if(sum > k) return;
        if(idx == arr.length) {
            if(sum == k) {
                System.out.println(list);
            }
            return;
        }


        list.add(arr[idx]);
        solve(idx+1, arr, list, sum+arr[idx], k);

        list.remove(list.size() - 1);
        solve(idx+1, arr, list, sum, k);
    }
}
