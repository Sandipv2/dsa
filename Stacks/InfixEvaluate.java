package Stacks;

import java.util.Stack;

public class InfixEvaluate {
    static int calculate(int v1, int v2, Stack<Character> op) {
        if (op.peek() == '+') return v1 + v2;
        if (op.peek() == '-') return v1 - v2;
        if (op.peek() == '*') return v1 * v2;
        if (op.peek() == '/') return v1 / v2;
        return 0;
    }

    public static void main(String[] args) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        String str = "9-(5+3)*4/6"; // --> 5

        for (char ch : str.toCharArray()) {
            int ascii = (int) (ch);

            if (ascii >= 48 && ascii <= 57) val.push(ascii - 48);

            else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            }

            else if(ch == ')') {
                while(op.peek() != '(') {
                    int v2 = val.pop();
                    int v1 = val.pop();

                    val.push(calculate(v1, v2, op));
                    op.pop();
                }
                op.pop();
            }

            else {
                if (ch == '+' || ch == '-') {
                    int v2 = val.pop();
                    int v1 = val.pop();

                    val.push(calculate(v1, v2, op));
                    op.pop();
                    op.push(ch);
                } else if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v2 = val.pop();
                        int v1 = val.pop();

                        if (op.peek() == '*') val.push(v1 * v2);
                        if (op.peek() == '/') val.push(v1 / v2);
                        op.pop();
                        op.push(ch);
                    }
                    else {
                        op.push(ch);
                    }
                }
            }
        }

        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            char ch = op.peek();

            val.push(calculate(v1, v2, op));
            op.pop();
        }

        System.out.println(val);
    }
}
