package Stacks;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String postfix = "953+4*6/-"; // --> -9/*+5346
        Stack<String> val = new Stack<>();

        for (char ch : postfix.toCharArray()) {
            if(Character.isDigit(ch)) {
                val.push(String.valueOf(ch));
            } else {
                String v2 = val.pop();
                String v1 = val.pop();

                val.push(ch + v1 + v2);
            }
        }

        System.out.println(val.peek());
    }
}
