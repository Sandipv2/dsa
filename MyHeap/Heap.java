package MyHeap;

import java.util.Arrays;

public class Heap {
    static class MinHeap {
        private int size;
        private int[] arr;

        MinHeap(int cap) {
            size = 0;
            arr = new int[cap];
        }

        MinHeap() {
            size = 0;
            int DEFAULT_CAPACITY = 10;
            arr = new int[DEFAULT_CAPACITY];
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private int left(int i) {
            return i * 2 + 1;
        }

        private int right(int i) {
            return i * 2 + 2;
        }

        private void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void add(int val) { // O(logn)
            if (size == arr.length) {
                System.out.println("Heap Overflow!!");
                return;
            }

            int index = size;
            arr[index] = val;
            int parent = parent(index);
            size++;

            while (index > 0) {
                if (arr[parent] > arr[index]) {
                    swap(parent, index);
                    index = parent;
                } else {
                    return;
                }
            }
        }

        public int remove() {
            if (size == 0) {
                System.out.println("Empty Heap");
                return Integer.MIN_VALUE;
            }
            int top = arr[0];

            // Step 1 : assign last elem to first
            arr[0] = arr[size - 1];

            // Step 2 : delete element
            size--;

            // Step 3 : place root node to correct position
            int i = 0;
            while (i < size) {
                int left = left(i);
                int right = right(i);

                if (left < size && arr[i] > arr[left]) {
                    swap(i, left);
                    i = left;
                } else if (right < size && arr[i] > arr[right]) {
                    swap(i, right);
                    i = right;
                } else {
                    break;
                }
            }
//            heapify(0);

            return top;
        }

        // Striver's
        public void heapify(int idx) {
            int left = left(idx);
            int right = right(idx);
            int smallest = idx; // assuming the given idx to be smallest

            if (left < size && arr[smallest] > arr[left]) {
                smallest = left;
            }
            if (right < size && arr[smallest] > arr[right]) {
                smallest = right;
            }

            /*smallest will store the minvalue index*/
            /*If the Minimum among the three nodes is the parent itself,
            that is Heap property satisfied so stop else call function recursively on Minvalue node*/

            if(smallest != idx) {
                swap(idx, smallest);
                heapify(smallest);
            }
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(12);
        heap.add(13);
        heap.add(5);
        heap.add(11);

        heap.print();
        heap.remove();
        heap.print();
        heap.remove();
        heap.print();
    }
}
