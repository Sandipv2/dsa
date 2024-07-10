package Recursions;

public class HarnoiTower {
    static void solve(int n, char source, char target, char helper, int[] count) {
        if(n == 1) {
            System.out.println("Moved Disk "+n+" from Rod "+source+" to Rod "+target);
            count[0]++;
            return;
        }

        count[0]++;
        solve(n-1, source, helper, target, count);
        System.out.println("Moved Disk "+n+" from Rod "+source+" to Rod "+target);
        solve(n-1, helper, target, source, count);
    }

// This can be done too!!
//    static void solve(int n, char source, char target, char helper) {
//            if(n == 0) return;
//
//            solve(n-1, source, helper, target);
//            System.out.println("Moved Disk "+n+" from Rod "+source+" to Rod "+target);
//            solve(n-1, helper, target, source);
//    }

    public static void main(String[] args) {
        int n = 6;
        int[] count = {0};

        // A - Source, C - Target, B - Helper
        solve(n, 'A','C','B', count);

        System.out.println("Total steps : " + count[0]);
    }
}
