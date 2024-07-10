package Recursions;

public class DigitProduct {
    public static void main(String[] args) {
        int ans = prod(123);
        System.out.println(ans);
    }

    static int prod(int n){
        if (n == 0)
                return 1;

        return (n % 10) * prod(n / 10);
    }
}
