package Stacks;

import java.util.Stack;

public class PostToInfix {
    public static void main(String[] args) {
        String postfix = "953+4*6/-"; // --> (9-(((5+3)*4)/6))
        Stack<String> val = new Stack<>();

        for(char ch : postfix.toCharArray()) {
            if(Character.isDigit(ch)) {
                val.push(String.valueOf(ch));
            } else {
                String v2 = val.pop();
                String v1 = val.pop();

                String exp = "(" + v1 + ch + v2 + ")";
                val.push(exp);
            }
        }

        System.out.println(val.peek());
    }
}
