package Stacks;

import java.util.Stack;

public class insetAtn {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        int idx = 3;
        int n = 12;

        Stack<Integer> tm = new Stack<>();
        while(st.size() > idx + 1) {
            tm.push(st.pop());
        }

        st.push(n);
        while (tm.size() > 0) {
            st.push(tm.pop());
        }

        System.out.println(st);
    }
}
