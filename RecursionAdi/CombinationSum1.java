package RecursionAdi;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 { // Duplicates are allowed
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        List<List<Integer>> result = new ArrayList<>();
        combination(0, nums, target, new ArrayList<>(), result);

        System.out.println(result);
    }

    static void combination(int idx, int[] nums, int target, List<Integer> list, List<List<Integer>> result) {
        if(idx == nums.length) {
           if(target == 0) {
               result.add(new ArrayList<>(list));
           }
           return;
        }

        if(nums[idx] <= target) {
            list.add(nums[idx]);
            combination(idx, nums, target - nums[idx], list, result);
            list.remove(list.size() - 1);
        }

        combination(idx + 1, nums, target, list, result);
    }
}
