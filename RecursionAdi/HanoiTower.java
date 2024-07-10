package RecursionAdi;

public class HanoiTower {
    public static void main(String[] args) {
        int n = 64;
        solve(n, 'A','B','C');
    }

    static void solve(int n, char source, char helper, char target) {
        if(n == 0) return;

        solve(n-1, source, target, helper);
        System.out.println(source + " -> " + target);
        solve(n-1, helper, source, target);
    }
}
