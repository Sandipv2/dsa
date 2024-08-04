// Time : O(nlogn)
// Space : O(1)

package MyHeap;

import java.util.Arrays;

public class HeapSort {
    static void heapify(int[] arr, int n, int idx) {
        int largest = idx;
        int left = idx * 2 + 1;
        int right = idx * 2 + 2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != idx) {
            int temp = arr[idx];
            arr[idx] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void sort(int[] arr) {
        int n = arr.length;

        // Leaf nodes are already in position, we can skip them
        // from n/2 to n-1 --> are leaf nodes, skip these

        // Build heap
        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract element from heap
        for(int i = n-1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            // Adjust the new placed element at 0
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
