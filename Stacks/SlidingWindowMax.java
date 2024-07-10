package Stacks;/*
* LeetCode Hard - 239
*
* Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
* Output: [3,3,5,5,6,7]
*/

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int n = nums.length;

        int[] ans = new int[n-k+1];

        Stack<Integer> st = new Stack<>(); // For next greater elements
        int[] nextGreat = new int[n];
        st.push(n-1);
        nextGreat[n-1] = n;

        for(int i = n-2; i >= 0; i--) {
            while(st.size() > 0 && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if(st.size() == 0) { // No greater found
                nextGreat[i] = n;
            } else {
                nextGreat[i] = st.peek();
            }
            st.push(i);
        }

        int j = 0; // for tracking window
        int ansIdx = 0; // for ans array

        for(int i = 0; i < n-k+1; i++) {
            if(j >= i+k) j = i;

            int max = nums[j];
            while(j < i+k) {
                max = nums[j];
                j = nextGreat[j];
            }
            ans[ansIdx++] = max;
        }

        System.out.println(Arrays.toString(ans));
    }
}
