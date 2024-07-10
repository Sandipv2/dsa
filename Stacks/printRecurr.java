package Stacks;

import java.util.Stack;

public class printRecurr {
    public static void printRecur(Stack st) {
        if(st.isEmpty()) {
            return;
        }

        int top = (int) st.pop();
        printRecur(st);
        System.out.print(top + " ");
        st.push(top);
    }

    public static void printReverse(Stack st) {
        if (st.isEmpty()) return;

        int top = (int)st.pop();
        System.out.print(top + " ");
        printReverse(st);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(12);
        st.push(13);
        st.push(14);
        st.push(15);

        printRecur(st);
        System.out.println();
        printReverse(st);
    }
}
