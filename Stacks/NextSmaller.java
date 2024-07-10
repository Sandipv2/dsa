package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmaller {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nextSmaller(arr)));
    }

    static int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(arr[n-1]);
        result[n-1] = -1;

        for(int i = n-2; i >= 0; i--) {
            while(st.size() > 0 && st.peek() > arr[i]) {
                st.pop();
            }

            if(st.size() == 0) {
                result[i] = -1;
            }
            else {
                result[i] = st.peek();
            }
            st.push(arr[i]);
        }

        return result;
    }
}
