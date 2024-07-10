package Recursions;/*
* Solved using Recurrsion!!
*/

public class LeetCode_1342 {
    public static void main(String[] args) {
        int ans = fun(8);
        System.out.println(ans);
    }

    static int fun(int n) {
        return helper(n, 0);
    }

    static int helper(int n, int c){
        if(n == 0)
            return c;

        // Mine Logic
        if(n % 2 == 0)
            n /= 2;
        else
            n--;

        c++;

        return helper(n, c);


         /*
            Kunal's :

            if(n % 2 == 0)
                return helper(n/2, c+1);

            return helper(n-1, c+1);
        */
    }

}
