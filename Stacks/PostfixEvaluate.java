package Stacks;

import java.util.Stack;

public class PostfixEvaluate {
    public static void main(String[] args) {
        String postfix = "953+4*6/-"; // --> 4
        Stack<Integer> val = new Stack<>();

        for(char ch : postfix.toCharArray()) {
            if(Character.isDigit(ch)) {
                val.push(Character.getNumericValue(ch));
            } else {
                int v2 = val.pop();
                int v1 = val.pop();

                if(ch == '+') val.push(v1 + v2);
                if(ch == '-') val.push(v1 - v2);
                if(ch == '*') val.push(v1 * v2);
                if(ch == '/') val.push(v1 / v2);
            }
        }

        System.out.println(val.peek());
    }
}
