package RecursionAdi;

import java.util.*;

public class JosephusProblem {
    static int solve(int k, List<Integer> arr, int i) {
        if(arr.size() == 1) {
            return arr.get(0);
        }

        i = (i + k - 1) % arr.size();
        arr.remove(i);

        return solve(k, arr, i);
    }

    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        List<Integer> arr = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            arr.add(i);
        }

        int ans = solve(k, arr, 0);
        System.out.println(ans);
    }
}
