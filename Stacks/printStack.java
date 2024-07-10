package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class printStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter size of stack : ");
        n = sc.nextInt();

        System.out.println("Enter nums : ");
        for (int i = 1; i <= n; i++) {
            st.push(sc.nextInt());
        }

        Stack<Integer> temp = new Stack<>();
        while(st.size() > 0) {
            temp.push(st.pop());
        }

        while(temp.size() > 0) {
            int a = temp.pop();
            st.push(a);
            System.out.print(a + " ");
        }
        System.out.println(st);
    }
}
