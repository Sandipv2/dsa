package RecursionAdi;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }

    static void reverse(Stack<Integer> st) {
        if(st.size() == 1) {
            return;
        }

        int top = st.pop();
        reverse(st);
        insert(st, top);
    }

    static void insert(Stack<Integer> st, int elem) {
        if(st.size() == 0) {
            st.push(elem);
            return;
        }

        int temp = st.pop();
        insert(st, elem);
        st.push(temp);
    }
}
