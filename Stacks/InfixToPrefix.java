package Stacks;/*
* PW Raghav Stack
*/

import java.util.Stack;

public class InfixToPrefix {

    static void evaluate(Stack<String> val, Stack<Character> op) {
        String v2 = val.pop();
        String v1 = val.pop();

        val.push(op.pop() + v1 + v2); // Infix to prefix;
//        val.push(v1 + v2 + op.pop()); // Infix to postfix;
    }

    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(char ch : infix.toCharArray()) {
            int ascii = (int)(ch);
            if(ascii >= 48 && ascii <= 57) {
                val.push(String.valueOf(ascii - 48));
            }
            else if(op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            }
            else if(ch == ')') {
                while(op.peek() != '(') {
                    evaluate(val, op);
                }
                op.pop();
            }
            else {
                if(ch == '+' || ch == '-') {
                    evaluate(val, op);
                    op.push(ch);
                }
                else if(ch == '*' || ch == '/') {
                    if(op.peek() == '*' || op.peek() == '/') {
                        evaluate(val, op);
                        op.push(ch);
                    }
                    else {
                        op.push(ch);
                    }
                }
            }
        }

        while(val.size() > 1) {
            evaluate(val, op);
        }

        String prefix = val.pop();
        System.out.println(prefix);
    }
}
