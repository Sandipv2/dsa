package Recursions;

import java.util.Stack;

public class SortStack {
    static void sort(Stack<Integer> st) {
        if(st.size() == 1) {
            return;
        }

        int temp = st.pop();
        sort(st);
        insert(st, temp);
    }

    static void insert(Stack<Integer> st, int temp) {
        if(st.size() == 0 || temp > st.peek()) {
            st.push(temp);
            return;
        }

        int val = st.pop();
        insert(st, temp);
        st.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(1);
        st.push(5);
        st.push(4);

        System.out.println(st);
        sort(st);
        System.out.println(st);
    }
}
