package Recursions;

public class Issorted {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,8};
        System.out.println(issort(arr, 0));
    }

    static boolean issort(int[] arr, int i){
        if(i == arr.length-1) return true;

        return (arr[i] < arr[i+1]) && issort(arr, i+1);
    }
}
