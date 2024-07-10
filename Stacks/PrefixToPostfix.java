package Stacks;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String prefix = "-9/*+5346"; // --> 953+4*6/-
        Stack<String> val = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if(Character.isDigit(ch)) {
                val.push(String.valueOf(ch));
            } else {
                String v1 = val.pop();
                String v2 = val.pop();

                val.push(v1 + v2 + ch);
            }
        }

        System.out.println(val.peek());
    }
}
