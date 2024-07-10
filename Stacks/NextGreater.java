package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextGreater(arr)));
    }

    static int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        st.push(nums[n-1]);
        result[n-1] = -1;

        for(int i = n-2; i >= 0; i--) {
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
