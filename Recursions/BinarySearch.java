package Recursions;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,4,6,7,9,11,15};
        System.out.println(find(arr, 4, 0, arr.length-1));
    }

    static int find(int[] arr, int target, int s, int e){
        if(s > e)
            return -1;

        int mid = (s+e)/2;

        if (arr[mid] == target)
            return mid;

        if(target < arr[mid])
            return find(arr, target, s, mid-1);

        return find(arr, target, mid+1, e);
    }
}
