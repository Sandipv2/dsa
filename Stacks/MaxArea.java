package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class MaxArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        int[] nse = nextSmaller(heights);
        int[] pse = prevSmaller(heights);
        int maxArea = -1;

        for(int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            if(width * heights[i] > maxArea) {
                maxArea = width * heights[i];
            }
        }

        System.out.println(maxArea);
    }

    static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        result[n-1] = n;
        st.push(n-1);

        for(int i = n-2; i >= 0; i--) {
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.size() == 0) {
                result[i] = n;
            }
            else {
                result[i] = st.peek();
            }
            st.push(i);
        }

        return result;
    }

    static int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        result[0] = -1;
        st.push(0);

        for(int i = 1; i < n; i++) {
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.size() == 0) {
                result[i] = -1;
            }
            else {
                result[i] = st.peek();
            }
            st.push(i);
        }

        return result;
    }
}