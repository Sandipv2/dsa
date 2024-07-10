package Stacks;

import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] args) {
        String prefix = "-9/*+5346"; // --> 4
        Stack<Integer> val = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            if(Character.isDigit(ch)) {
                val.push(Character.getNumericValue(ch));
            } else {
                int v1 = val.pop(); // First pop is our first value
                int v2 = val.pop();

                if(ch == '+') val.push(v1 + v2);
                if(ch == '-') val.push(v1 - v2);
                if(ch == '*') val.push(v1 * v2);
                if(ch == '/') val.push(v1 / v2);
            }
        }

        System.out.println(val.peek());
    }
}
