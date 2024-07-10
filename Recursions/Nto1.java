package Recursions;

public class Nto1 {
    public static void main(String[] args) {
        _1ton(5);
    }

    // n to 1;
    static void nto1(int n){
        if (n == 0)
            return;

        System.out.println(n);
        nto1(n - 1);
    }

    // 1 to n;
    static void _1ton(int n){
        if(n == 0)
            return;

        _1ton(n-1);

        System.out.println(n);
    }
}
