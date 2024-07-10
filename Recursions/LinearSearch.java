package Recursions;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,4,7,9,8};
        System.out.println(find(arr,3,0));
    }

    static int find(int[] arr, int target, int index) {
        if(index == arr.length) {
            return -1;
        }

        if(arr[index] == target) {
            return index;
        }

        return find(arr, target, index+1);
    }
}
