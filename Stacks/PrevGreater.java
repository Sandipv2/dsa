package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class PrevGreater {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(prevGreater(arr)));
    }

    static int[] prevGreater(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        result[0] = -1;
        st.push(nums[0]);

        for(int i = 1; i < n; i++) {
            while(st.size() > 0 && st.peek() < nums[i]) {
                st.pop();
            }

            if(st.size() == 0) {
                result[i] = -1;
            }
            else {
                result[i] = st.peek();
            }
            st.push(nums[i]);
        }

        return result;
    }
}
