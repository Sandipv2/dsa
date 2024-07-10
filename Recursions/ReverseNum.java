package Recursions;

public class ReverseNum {
    public static void main(String[] args) {
        int ans = reverse(12345);
        System.out.println(ans);
    }

    static int reverse(int n){
        // sometimes you might need some additional variables in the argument
        // in that case, make another function
        return helper(n, 0);
    }

    static int helper(int n, int rev){
        if (n==0)
            return rev;

        rev = (rev * 10) + n % 10;

        return helper(n/10, rev);
    }
}
