package RecursionAdi;

import java.util.Stack;

public class DeleteMidStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st);
        removeMid(st, st.size() / 2);
        System.out.println(st);
    }

    static void removeMid(Stack<Integer> st, int k) {
        if(k == 0) {
            st.pop();
            return;
        }

        int top = st.pop();
        removeMid(st, k-1);
        st.push(top);
    }
}
