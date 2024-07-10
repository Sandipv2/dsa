package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class PrevSmaller {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,8,6,3,4};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(prevSmaller(arr)));
    }

    static int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        result[0] = -1;
        st.add(arr[0]);

        for(int i = 1; i < n; i++) {
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
