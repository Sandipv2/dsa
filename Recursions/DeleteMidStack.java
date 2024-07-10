package Recursions;

import java.util.*;

public class DeleteMidStack {
    static void removeMid(Stack<Integer> st, int k) {
        if(k == 0) {
            st.pop();
            return;
        }

        int t = st.pop();
        removeMid(st, k-1);
        st.push(t);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);
        st.add(4);
        st.add(5);
        System.out.println(st);
        removeMid(st, st.size()/2);
        System.out.println(st);
    }
}
