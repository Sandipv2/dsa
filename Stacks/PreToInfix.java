package Stacks;

import java.util.Stack;

public class PreToInfix {
    public static void main(String[] args) {
        String prefix = "-9/*+5346"; // --> (9-(((5+3)*4)/6));
        Stack<String> val = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if(Character.isDigit(ch)) {
                val.push(String.valueOf(ch));
            } else {
                String v1 = val.pop();
                String v2 = val.pop();

                String exp = "(" + v1 + ch + v2 + ")";
                val.push(exp);
            }
        }

        System.out.println(val.peek());
    }
}
