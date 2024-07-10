package Recursions;

import java.util.Stack;

public class ReverseStack {
    static void rev(Stack<Integer> st) {
        if(st.size() == 1) {
            return;
        }

        int temp = st.pop();
        rev(st);
        insert(st, temp);
    }

    static void insert(Stack<Integer> st, int temp) {
        if(st.size() == 0) {
            st.push(temp);
            return;
        }

        int val = st.pop();
        insert(st, temp);
        st.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);

        System.out.println(st);
        rev(st);
        System.out.println(st);
    }
}
