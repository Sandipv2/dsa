package RecursionAdi;

public class KthSymbol {
    public static void main(String[] args) {
        System.out.println(symbol(4, 2));
    }

    static int symbol(int n, int k) {
        if(n == 1 && k == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2, n-1) / 2;

        if(k <= mid) {
            return symbol(n-1, k);
        }

        return 1 - symbol(n-1, k-mid);
    }
}
