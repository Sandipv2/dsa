package Recursions;

public class Countzeroes {
    public static void main(String[] args) {
        int ans = count(1204020);
        System.out.println(ans);
    }

    static int count(int n){
        return helper(n, 0);
    }

    static int helper(int n, int c){
        if(n == 0)
            return c;

        if(n%10 == 0)
            c++;

        return helper(n/10, c);
    }
}
