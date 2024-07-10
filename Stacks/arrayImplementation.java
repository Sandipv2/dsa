package Stacks;

public class arrayImplementation {
    public static class Stack {
        int[] arr = new int[5];
        int idx = 0;

        void push(int k) {
            if(isFull()) {
                System.out.println("Stack is full");
                return;
            }
            arr[idx++] = k;
        }

        int pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty.");
                return -1;
            }

            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            return top;
        }

        int peek() {
            return arr[idx-1];
        }

        int size() {
            if(isFull()) return arr.length;
            return idx;
        }

        void print() {
            if(isEmpty()) {
                System.out.println("Stack is empty.");
                return;
            }
            for (int i = 0; i < idx; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        boolean isFull() {
            if (idx == arr.length) {
                return true;
            }
            return false;
        }

        boolean isEmpty() {
            if (idx == 0) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        st.push(55);

        st.print();
        System.out.println("\nsize : "+st.size());
        System.out.println("Removed : "+st.pop());

        st.print();
        System.out.println("\nsize : "+st.size());
    }
}
