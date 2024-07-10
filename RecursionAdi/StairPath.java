package RecursionAdi;

public class StairPath {
    public static void main(String[] args) {
        int steps = solve(5, 0, "");
        System.out.println("Steps : "+steps);
//        System.out.println(solve(5));
    }

    // Mine :
    static int solve(int n, int i, String path) {
        if(i == n && i != 0) {
            System.out.println(path);
            return 1;
        }
        if(i > n) return 0;

        int one = solve(n, i + 1, path + "1");
        int two = solve(n, i + 2, path + "2");

        return one + two;
    }

    // Raghav's PW
    static int solve(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        int ways = solve(n-1) + solve(n-2);
        return ways;
    }
}
