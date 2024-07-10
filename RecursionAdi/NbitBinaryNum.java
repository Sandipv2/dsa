package RecursionAdi;

public class NbitBinaryNum {
//https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

    static void solve(int ones, int zeroes, int n, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }

        solve(ones+1, zeroes, n-1, str + "1");

        if(ones > zeroes) {
            solve(ones, zeroes+1, n-1, str + "0");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        solve(0,0,n,"");
    }
}
