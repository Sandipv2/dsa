package RecursionAdi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,6,1,7,9,5,8,10};
        int n = arr.length;

        mergeSort(0, n-1, arr);

        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int low, int high, int[] arr) {
        if(low == high) return;

        int mid = low + (high - low) / 2;

        mergeSort(low, mid, arr);
        mergeSort(mid+1, high, arr);

        merge(low, mid, high, arr);
    }

    static void merge(int low, int mid, int high, int[] arr) {
        List<Integer> list = new ArrayList<>();

        int l = low;
        int r = mid+1;

        while(l <= mid && r <= high) {
            if(arr[l] < arr[r]) {
                list.add(arr[l++]);
            } else {
                list.add(arr[r++]);
            }
        }

        while(l <= mid) {
            list.add(arr[l++]);
        }

        while(r <= high) {
            list.add(arr[r++]);
        }

        for(int i = 0; i < list.size(); i++) {
            arr[low + i] = list.get(i);
        }
    }
}
