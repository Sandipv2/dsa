package RecursionAdi;

public class Zigzag {
    public static void main(String[] args) {
        solve(3);
    }

    static void solve(int n) {
        if(n == 0) return;

        System.out.print(n);
        solve(n-1);
        System.out.print(n);
        solve(n-1);
        System.out.print(n);
    }
}
