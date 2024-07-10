package RecursionAdi;

public class Power {
    public static void main(String[] args) {
        long ans = solvelog(2, 32);
        System.out.println(ans);
    }

    // Naive approach
    static long solve(long base, long power) {
        if(power == 0) return 1;

        return base * solve(base, power-1);
    }

    // Optimised (Logarithmic);
    // f(b,p) = f(b,p/2) * f(b,p/2);
    static long solvelog(long base, long power) {
        if(power == 0) return 1;

        long half = solvelog(base, power/2);

        if(power % 2 == 0) {
            return half * half;
        }

        return half * half * base;
//        Same as above;
//        if(power % 2 == 0) {
//            return solvelog(base, power/2) * solvelog(base, power/2);
//        }
//
//        return solvelog(base, power/2) * solvelog(base, power/2) * base;
    }
}
