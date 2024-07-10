package Recursions;/*
 * Solved without using Recurrsion!!
*/

public class Lc1342_norecurr {
    public static void main(String[] args) {
        int ans = fun(41);
        System.out.println(ans);
    }

    static int fun(int n){
        int c = 0;

        while(n > 0){
            if(n % 2 == 0)
                n /= 2;
            else
                n--;

            c++;
        }

        return c;
    }
}
