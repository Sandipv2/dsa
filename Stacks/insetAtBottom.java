package Stacks;

import java.util.Stack;

public class insetAtBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        Stack<Integer> tm = new Stack<>();
        while (st.size() > 0) {
            tm.push(st.pop());
        }

        int a = 11;
        tm.push(a);
        while (tm.size() > 0) {
            st.push(tm.pop());
        }

        System.out.println(st);
    }
}
