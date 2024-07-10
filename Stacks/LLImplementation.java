package Stacks;

public class LLImplementation {
    public static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static class Stack {
        Node head = null;
        int size = 0;

        void push(int k) {
            Node temp = new Node(k);
            temp.next = head;
            head = temp;
            size++;
        }

        int pop() {
            if (head == null) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = head.val;
            head = head.next;
            size--;
            return top;
        }

        int peek() {
            if (head == null) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.val;
        }

        void helper(Node temp) {
            if (temp == null) {
                return;
            }
            helper(temp.next);
            System.out.print(temp.val+" ");
        }

        void display() {
            helper(head);
        }

        void displayRev() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(14);

        st.display();
        System.out.println();
        st.displayRev();
    }
}
