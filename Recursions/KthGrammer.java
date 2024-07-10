package Recursions;

public class KthGrammer {
    static int kthElement(int n, int k) {
        if(n == 1 && k == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, n-1) / 2;

        if(k <= mid) {
            return kthElement(n-1, k);
        }

        return 1 - kthElement(n-1, k-mid);
    }

    public static void main(String[] args) {
        System.out.println(kthElement(3,3));
    }
}
