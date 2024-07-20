package RecursionAdi;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,7,9,5,8,10};
        int n = arr.length;
        sort(0, n-1, arr);

        System.out.println(Arrays.toString(arr));
    }

    static void sort(int low, int high, int[] arr) {
        if(low > high) return;

        int pivotIdx = partition(low, high, arr);

        sort(low, pivotIdx-1, arr);
        sort(pivotIdx+1, high, arr);
    }

    static int partition(int low, int high, int[] arr) {
        int pivot = arr[high];
        int j = low;

        for(int i = low; i < high; i++) {
            if(arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        int temp = arr[high];
        arr[high] = arr[j];
        arr[j] = temp;

        return j;
    }
}
